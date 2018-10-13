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
import com.vamos.domain.Motorista;
import com.vamos.dto.EstudanteDTO;
import com.vamos.dto.MotoristaDTO;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.repositories.MotoristaRepository;
import com.vamos.resources.exception.FieldMessage;


public class MotoristaUpdateValidator implements ConstraintValidator<MotoristaUpdate, MotoristaDTO>  {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private MotoristaRepository repository;
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Override
	public void initialize(MotoristaUpdate ann) {
	}

	@Override
	public boolean isValid(MotoristaDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Motorista aux = repository.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId))
			list.add(new FieldMessage("email", "Email ja existente"));
		
		Estudante aux2 = estudanteRepository.findByEmail(objDto.getEmail());
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
