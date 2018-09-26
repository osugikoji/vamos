package com.vamos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.domain.Estudante;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	public Estudante find(Integer id) {
		
		Optional<Estudante> obj = estudanteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Estudante.class.getName()));
	}
}
