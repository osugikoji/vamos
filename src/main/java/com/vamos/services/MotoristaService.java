package com.vamos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Motorista;
import com.vamos.dto.MotoristaDTO;
import com.vamos.dto.MotoristaNewDTO;
import com.vamos.repositories.MotoristaRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;


@Service
public class MotoristaService {

	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public Motorista find(Integer id) {
		
		Optional<Motorista> obj = motoristaRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Motorista.class.getName()));
	}
	
	public Motorista findByEmail(String email) {
		Motorista obj = motoristaRepository.findByEmail(email);
		if(obj == null) {
			//throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +  ", Tipo: " + Motorista.class.getName());
		}
		return obj;
	}
	
	@Transactional
	public Motorista insert(Motorista obj) {
		obj.setId(null);
		obj = motoristaRepository.save(obj);
		return obj;
	}
	
	public Motorista update(Motorista obj) {
		Motorista newObj = find(obj.getId());
		updateData(newObj, obj);
		return motoristaRepository.save(newObj);
	}
	
	private void updateData(Motorista newObj, Motorista obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setDataNasc(obj.getDataNasc());
	}

	public Motorista fromDTO(MotoristaDTO objDTO) {
		return new Motorista(null,objDTO.getNome(),objDTO.getEmail(),null,objDTO.getDataNasc(),objDTO.getCpf(), objDTO.getCnh());
	}
	
	public Motorista fromDTO(MotoristaNewDTO objDTO) {
		Motorista motorista = new Motorista(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getDataNasc(), objDTO.getCpf(), objDTO.getCnh());
		motorista.getTelefones().add(objDTO.getTelefone1());
		if(objDTO.getTelefone2() != null) {
			motorista.getTelefones().add(objDTO.getTelefone2());
		}
		
		return motorista;
	}
}
