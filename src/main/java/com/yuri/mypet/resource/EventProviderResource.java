package com.yuri.mypet.resource;

import com.yuri.mypet.domain.EventProvider;
import com.yuri.mypet.dto.EventProviderDTO;
import com.yuri.mypet.dto.EventProviderNewDTO;
import com.yuri.mypet.service.EventProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value = "/calendar")
public class EventProviderResource {

    @Autowired
    private EventProviderService varEventProviderService;

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EventProvider> buscar(@PathVariable Integer id) {
        EventProvider varEventProvider = varEventProviderService.find(id);
        return ResponseEntity.ok().body(varEventProvider);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody EventProviderNewDTO newVarEventProviderNewDTO) {
        EventProvider varEventProvider = varEventProviderService.fromDto(newVarEventProviderNewDTO);
        varEventProvider = varEventProviderService.insert(varEventProvider);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(varEventProvider.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody EventProviderDTO varEventProviderDTO,
                                       @PathVariable Integer id) {
        EventProvider varEventProvider = varEventProviderService.fromDto(varEventProviderDTO);
        varEventProvider.setId(id);
        varEventProvider = varEventProviderService.update(varEventProvider);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        varEventProviderService.delete(id);
        return ResponseEntity.noContent().build();

    }

   // @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventProviderDTO>> findAll() {

        List<EventProvider> listEventProvider = varEventProviderService.findAll();
        List<EventProviderDTO> listDtoEventProvider = listEventProvider.stream().map(obj -> new EventProviderDTO(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDtoEventProvider);
    }
    @GetMapping(value = "/all")
    public String getEvents() {
        String jsonMsg = null;
        try {
            List<EventProvider> events = new ArrayList<EventProvider>();
            EventProvider event = new EventProvider();
            event.setTitle("first event");
            event.setStart("2017-10-01");
            events.add(event);

            event = new EventProvider();
            event.setTitle("second event");
            event.setStart("2017-10-11");
            event.setEnd("2017-10-12");
            events.add(event);

            // FullCalendarにエンコード済み文字列を渡す
            ObjectMapper mapper = new ObjectMapper();
            jsonMsg =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(events);
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        }
        return jsonMsg;
    }
}

