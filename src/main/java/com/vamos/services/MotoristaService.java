package com.vamos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.models.Motorista;
import com.vamos.repositories.MotoristaRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;

@Service
public class MotoristaService {
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public Motorista find(long id) {
			Optional<Motorista> obj = motoristaRepository.findById(id); 
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Motorista.class.getName()));
	}
}
