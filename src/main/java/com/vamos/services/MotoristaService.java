package com.vamos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.models.Motorista;
import com.vamos.repositories.MotoristaRepository;

@Service
public class MotoristaService {
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public Motorista find(Integer id) {
		try {
			Optional<Motorista> obj = motoristaRepository.findById(id); 
			return obj.orElseThrow(() -> new Exception());
		} catch (Exception e) {
			return null;
		}
	}
}
