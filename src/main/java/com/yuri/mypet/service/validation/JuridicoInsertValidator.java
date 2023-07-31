package com.yuri.mypet.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.dto.PetClientNewDTO;
import com.yuri.mypet.dto.PetProviderNewDTO;
import com.yuri.mypet.repositories.PetClientRepository;
import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.resource.exception.FieldMessage;
import com.yuri.mypet.service.validation.utils.BR;

import org.springframework.beans.factory.annotation.Autowired;

public class JuridicoInsertValidator implements ConstraintValidator<JuridicoInsert, PetProviderNewDTO> {

	@Autowired
	PetProviderRepository petProviderRepository;

	@Override
	public void initialize(JuridicoInsert ann) {
	}

	@Override
	public boolean isValid(PetProviderNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipoPerfil().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpf()) &&!BR.isValidCPF(objDto.getCpf())) {
			list.add(new FieldMessage("cpf", "cpf invalido"));
		}

		PetProvider aux = petProviderRepository.findByEmail(objDto.getEmail());
		if (aux != null) { // verificando se email já existe
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