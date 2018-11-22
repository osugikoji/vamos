package com.vamos.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vamos.domain.Student;
import com.vamos.domain.Driver;
import com.vamos.dto.input.NewDriverDTO;
import com.vamos.repositories.StudentRepository;
import com.vamos.repositories.DriverRepository;
import com.vamos.resources.exception.FieldMessage;
import com.vamos.services.validation.utils.BR;

public class MotoristaInsertValidator implements ConstraintValidator<MotoristaInsert, NewDriverDTO>  {

	@Autowired
	private DriverRepository repository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void initialize(MotoristaInsert ann) {
	}

	@Override
	public boolean isValid(NewDriverDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
//		if(!BR.isValidCPF(objDto.getCpf()))
//			list.add(new FieldMessage("cpfOuCnpj", "CPF invalido"));
		
		Driver aux = repository.findByEmail(objDto.getEmail());
		if(aux != null)
			list.add(new FieldMessage("email", "Email já existente"));
		
		Student aux2 = studentRepository.findByEmail(objDto.getEmail());
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
