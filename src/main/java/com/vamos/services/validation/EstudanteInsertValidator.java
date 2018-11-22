package com.vamos.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vamos.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

import com.vamos.domain.Driver;
import com.vamos.dto.StudentNewDTO;
import com.vamos.repositories.StudentRepository;
import com.vamos.repositories.DriverRepository;
import com.vamos.resources.exception.FieldMessage;

public class EstudanteInsertValidator implements ConstraintValidator<EstudanteInsert, StudentNewDTO>  {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public void initialize(EstudanteInsert ann) {
	}

	@Override
	public boolean isValid(StudentNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Student aux = repository.findByEmail(objDto.getEmail());
		if(aux != null)
			list.add(new FieldMessage("email", "Email já existente"));
		
		Driver aux2 = driverRepository.findByEmail(objDto.getEmail());
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
