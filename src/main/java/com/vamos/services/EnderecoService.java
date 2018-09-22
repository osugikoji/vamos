package com.vamos.services;

import java.util.Optional;

import com.vamos.models.Endereco;
import com.vamos.repositories.EnderecoRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;

public class EnderecoService {
	
	private EnderecoRepository enderecoRepository;
	
	public Endereco find(long id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Endereco não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}
}
