package com.vamos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.domain.Cidade;
import com.vamos.domain.Endereco;
import com.vamos.domain.Estado;
import com.vamos.domain.Estudante;
import com.vamos.domain.Motorista;
import com.vamos.domain.Usuario;
import com.vamos.repositories.CidadeRepository;
import com.vamos.repositories.EnderecoRepository;
import com.vamos.repositories.EstadoRepository;
import com.vamos.repositories.MotoristaRepository;

@Service
public class DBService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private MotoristaRepository motoristaRepository; 
	
	public void instantiateDataBase() throws ParseException {
		
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Motorista motorista1 = new Motorista(null, "José da Silva", "jose@gmail.com", "123", sdf.parse("08/03/1965"), "018.389.556.82", "12597" );
		motoristaRepository.saveAll(Arrays.asList(motorista1));
		
		Estudante estudante1 = new Estudante(null, "Koji Osugi", "koji097@gmail.com", "1234", sdf.parse("08/03/1997"));
		Estudante estudante2 = new Estudante(null, "Joao Zullo", "zullo@gmail.com", "1234", sdf.parse("08/03/1995"));
		
		Endereco endereco1 = new Endereco(null, "Rua Jose Bernardinetti", "180", null, "Jardim Recanto do Valle", cidade2, estudante1);
		Endereco endereco2 = new Endereco(null, "Rua Itaperuna", "801", null, "Icarai", cidade3, estudante2);
		
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
		
		
	}

}
