package com.vamos.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.domain.Cidade;
import com.vamos.domain.Estado;
import com.vamos.repositories.CidadeRepository;
import com.vamos.repositories.EstadoRepository;

@Service
public class DBService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public void instantiateDataBase() {
		
		Estado estado1 = new Estado(null,"SP");
		Estado estado2 = new Estado(null,"MG");
		
		Cidade cidade1 = new Cidade(null,"Campinas",estado1);
		Cidade cidade2 = new Cidade(null,"Indaiatuba",estado1);
		Cidade cidade3 = new Cidade(null,"Divinopolis",estado2);
		Cidade cidade4 = new Cidade(null,"Belo Horizonte",estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3,cidade4));
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3,cidade4));
	}

}
