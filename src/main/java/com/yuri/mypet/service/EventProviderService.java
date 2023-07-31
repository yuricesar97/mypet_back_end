package com.yuri.mypet.service;

import com.yuri.mypet.domain.EventProvider;
import com.yuri.mypet.dto.EventProviderDTO;
import com.yuri.mypet.dto.EventProviderNewDTO;
import com.yuri.mypet.repositories.EventProviderRepository;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class EventProviderService {

    @Autowired
    EventProviderRepository varEventProviderRepository;

    // CRUD
    /////////////////////////////////////////////////////////////////////////////////////////////////
    public EventProvider find(Integer id) {
        Optional<EventProvider> varOptinionalEventProvider = varEventProviderRepository.findById(id);
        return varOptinionalEventProvider.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", tipo: " + EventProvider.class.getName()));

    }

   


    public EventProvider insert(EventProvider varEventProvider) {
        varEventProvider.setId(null);
        varEventProvider = varEventProviderRepository.save(varEventProvider);
        return varEventProvider;
    }

    public EventProvider update(EventProvider varEventProvider) {
        EventProvider newVarEventProvider = find(varEventProvider.getId());
        updateData(newVarEventProvider, varEventProvider);
        return varEventProviderRepository.save(newVarEventProvider);
    }

    public void delete(Integer id) {
        find(id);
        try {
            varEventProviderRepository.deleteById(id);

        } catch(DataIntegrityViolationException varDataIntegrityViolationException) {
            throw new DataInternalException("Não é possivel exclui o evento do provedor EventProvider");
        }
    }

    // FIM CRUD
    /////////////////////////////////////////////////////////////////////////////////////////////////


    private void updateData(EventProvider newVarEventProvider, EventProvider varEventProvider) {
      
        newVarEventProvider.setTitle(varEventProvider.getTitle());
        newVarEventProvider.setDescription(varEventProvider.getDescription());
        newVarEventProvider.setStart(varEventProvider.getStart());
        newVarEventProvider.setEnd(varEventProvider.getEnd());
    }

    public List<EventProvider> findAll() {
        return varEventProviderRepository.findAll();
    }

    public EventProvider fromDto(EventProviderDTO varEventProviderDTO) {
        return new EventProvider(varEventProviderDTO.getId(),
                varEventProviderDTO.getTitle(),
                varEventProviderDTO.getDescription(), varEventProviderDTO.getStart(),
                varEventProviderDTO.getEnd());
    }

    public EventProvider fromDto(EventProviderNewDTO newVarEventProviderNewDTO) {
        return new EventProvider(null,
                newVarEventProviderNewDTO.getTitle(), newVarEventProviderNewDTO.getDescription(),
                newVarEventProviderNewDTO.getStart(), newVarEventProviderNewDTO.getEnd());

    }


}
