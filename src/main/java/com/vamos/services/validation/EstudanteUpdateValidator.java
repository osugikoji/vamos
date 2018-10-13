package com.vamos.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.vamos.domain.Estudante;
import com.vamos.dto.EstudanteDTO;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.resources.exception.FieldMessage;


public class EstudanteUpdateValidator implements ConstraintValidator<EstudanteUpdate, EstudanteDTO>  {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private EstudanteRepository repository;
	
	@Override
	public void initialize(EstudanteUpdate ann) {
	}

	@Override
	public boolean isValid(EstudanteDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Estudante aux = repository.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId))
			list.add(new FieldMessage("email", "Email ja existente"));
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
