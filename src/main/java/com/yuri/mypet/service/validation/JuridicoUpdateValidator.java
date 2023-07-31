package com.yuri.mypet.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.dto.PetProviderDTO;
import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.resource.exception.FieldMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class JuridicoUpdateValidator implements ConstraintValidator<JuridicoUpdate, PetProviderDTO> {

	@Autowired
	private HttpServletRequest request; // permite pegar o parametro da uri
	@Autowired
	private PetProviderRepository petProviderRepository;

	@Override
	public void initialize(JuridicoUpdate ann) {
	}

	public boolean isValid(PetProviderDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		// Map estrutura de dados, chave e valor exemplo(chave id, valor 2)

		List<FieldMessage> list = new ArrayList<>();

		PetProvider aux = petProviderRepository.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) { // verificando se email já existe
			list.add(new FieldMessage("Email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}