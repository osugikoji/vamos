package com.vamos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Cidade;
import com.vamos.domain.Endereco;
import com.vamos.domain.Estudante;
import com.vamos.domain.Instituicao;
import com.vamos.dto.EstudanteNewDTO;
import com.vamos.repositories.EnderecoRepository;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Estudante find(Integer id) {
		
		Optional<Estudante> obj = estudanteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Estudante.class.getName()));
	}
	
	public Estudante findByEmail(String email) {
		Estudante obj = estudanteRepository.findByEmail(email);
		if(obj == null) {
			//throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
			new ObjectNotFoundException("Objeto não encontrado! Id: " +  ", Tipo: " + Estudante.class.getName());
		}
		return obj;
	}
	
	@Transactional
	public Estudante insert(Estudante obj) {
		obj.setId(null);
		obj = estudanteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Estudante fromDTO(EstudanteNewDTO objDTO) {
		Instituicao instituicao = new Instituicao(objDTO.getInstituicaoId(), null);
		Estudante estudante = new Estudante(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getSenha(), objDTO.getDataNasc(), instituicao);
		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null);
		Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), objDTO.getBairro(), cidade, estudante);
		estudante.getEnderecos().add(endereco);
		estudante.getTelefones().add(objDTO.getTelefone1());
		if(objDTO.getTelefone2() != null) {
			estudante.getTelefones().add(objDTO.getTelefone2());
		}
		
		return estudante;
	}
}
