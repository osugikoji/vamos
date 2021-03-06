package com.vamos.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.vamos.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.vamos.domain.Driver;
import com.vamos.dto.input.UpdateStudentDTO;
import com.vamos.repositories.StudentRepository;
import com.vamos.repositories.DriverRepository;
import com.vamos.resources.exception.FieldMessage;


public class EstudanteUpdateValidator implements ConstraintValidator<EstudanteUpdate, UpdateStudentDTO>  {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public void initialize(EstudanteUpdate ann) {
	}

	@Override
	public boolean isValid(UpdateStudentDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Student aux = repository.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId))
			list.add(new FieldMessage("email", "Email ja existente"));
		
		Driver aux2 = driverRepository.findByEmail(objDto.getEmail());
		if(aux2 != null && !aux2.getId().equals(uriId))
			list.add(new FieldMessage("email", "Email ja existente"));
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
