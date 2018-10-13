package com.vamos.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vamos.domain.Estudante;
import com.vamos.domain.Motorista;
import com.vamos.dto.MotoristaNewDTO;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.repositories.MotoristaRepository;
import com.vamos.resources.exception.FieldMessage;
import com.vamos.services.validation.utils.BR;

public class MotoristaInsertValidator implements ConstraintValidator<MotoristaInsert, MotoristaNewDTO>  {

	@Autowired
	private MotoristaRepository repository;
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Override
	public void initialize(MotoristaInsert ann) {
	}

	@Override
	public boolean isValid(MotoristaNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(!BR.isValidCPF(objDto.getCpf()))
			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
		
		Motorista aux = repository.findByEmail(objDto.getEmail());
		if(aux != null)
			list.add(new FieldMessage("email", "Email já existente"));
		
		Estudante aux2 = estudanteRepository.findByEmail(objDto.getEmail());
		if(aux2 != null)
			list.add(new FieldMessage("email", "Email já existente"));
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
