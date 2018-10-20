package com.vamos.services;

import com.vamos.domain.Grupo;
import com.vamos.domain.Instituicao;
import com.vamos.domain.IntegranteGrupo;
import com.vamos.domain.Motorista;
import com.vamos.domain.enums.Turno;
import com.vamos.dto.GrupoNewDTO;
import com.vamos.repositories.GrupoRepository;
import com.vamos.repositories.IntegranteGrupoRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private IntegranteGrupoRepository integranteGrupoRepository;

	@Autowired
	private EstudanteService estudanteService ;
	
	public Grupo find(Integer id) {
		
		Optional<Grupo> obj = grupoRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Grupo.class.getName()));
	}
	
	public List<Grupo> findGrouposByMotoristaId(Integer id) {
		return grupoRepository.findGruposByMotoristaId(id);
	}

	public List<Grupo> findGruposByEstudanteId(Integer id){
		List<IntegranteGrupo> listIntegranteGrupo = integranteGrupoRepository.findAll(estudanteService.find(id));
		List<Grupo> grupos = new ArrayList<>();
		for(IntegranteGrupo ig : listIntegranteGrupo){
			grupos.add(find(ig.getGrupo().getId()));
		}

		return grupos;
	}

	@Transactional
	public Grupo insert(Grupo obj) {
		obj.setId(null);
		obj = grupoRepository.save(obj);
		return obj;
	}

	public Grupo fromDTO(Integer motoristaId, GrupoNewDTO objDTO) {
		Instituicao instituicao = new Instituicao(objDTO.getInstituicaoId(), null);
		Motorista motorista = new Motorista(motoristaId, null, null, null, null, null, null);
		Grupo grupo = new Grupo(null, objDTO.getNome(), objDTO.getCapacidadeMax(), instituicao, Turno.toEnum(objDTO.getTurno()), motorista);
		return grupo;
	}
}
