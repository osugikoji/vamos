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
import com.vamos.domain.Grupo;
import com.vamos.domain.Instituicao;
import com.vamos.domain.Motorista;
import com.vamos.domain.enums.EstadoPagamento;
import com.vamos.domain.enums.Turno;
import com.vamos.repositories.CidadeRepository;
import com.vamos.repositories.EnderecoRepository;
import com.vamos.repositories.EstadoRepository;
import com.vamos.repositories.EstudanteRepository;
import com.vamos.repositories.GrupoRepository;
import com.vamos.repositories.InstituicaoRepository;
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
	@Autowired
	private EstudanteRepository estudanteRepository; 
	@Autowired
	private InstituicaoRepository instituicaoRepository;
	@Autowired
	private GrupoRepository grupoRepository;
	
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
		
		Instituicao instituicao1 = new Instituicao(null, "PUC-Campinas");
		Instituicao instituicao2 = new Instituicao(null, "Mackenzie");
		instituicaoRepository.saveAll(Arrays.asList(instituicao1,instituicao2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Motorista motorista1 = new Motorista(null, "José da Silva", "jose@gmail.com", "123", sdf.parse("08/03/1965"), "01838955682", "12597" );
		motorista1.getTelefones().addAll(Arrays.asList("1998652354","1933245698"));
		Motorista motorista2 = new Motorista(null, "Claudio Oliveira", "claudio@gmail.com", "123", sdf.parse("08/03/1975"), "01838955682", "12597" );
		motorista2.getTelefones().addAll(Arrays.asList("1996572345","1996357412"));
		motoristaRepository.saveAll(Arrays.asList(motorista1,motorista2));
		
		Grupo grupo1 = new Grupo(null, "Grupo do Jose Noturno", 15, instituicao1, Turno.NOTURNO, motorista1);
		Grupo grupo2 = new Grupo(null, "Grupo do Jose Matutino", 15, instituicao2, Turno.MATUTINO, motorista1);
		Grupo grupo3 = new Grupo(null, "Grupo do Claudio", 15, instituicao2, Turno.VESPERTINO, motorista2);
		grupoRepository.saveAll(Arrays.asList(grupo1,grupo2,grupo3));
		
		Estudante estudante1 = new Estudante(null, "Koji Osugi", "koji097@gmail.com", "1234", sdf.parse("08/03/1997"), instituicao1,grupo1,EstadoPagamento.PENDENTE);
		estudante1.getTelefones().addAll(Arrays.asList("19982252031","1933297165"));
		Estudante estudante2 = new Estudante(null, "Joao Zullo", "zullo@gmail.com", "1234", sdf.parse("08/03/1995"), instituicao2, grupo1,EstadoPagamento.PAGO);
		estudante2.getTelefones().addAll(Arrays.asList("37334456989","3798562456"));
		estudanteRepository.saveAll(Arrays.asList(estudante1,estudante2));
		
		grupo1.getEstudantes().addAll(Arrays.asList(estudante1));
		grupoRepository.saveAll(Arrays.asList(grupo1));
		
		Endereco endereco1 = new Endereco(null, "Rua Jose Bernardinetti", "180", null, "Jardim Recanto do Valle", cidade2, estudante1);
		Endereco endereco2 = new Endereco(null, "Rua Itaperuna", "801", null, "Icarai", cidade3, estudante2);
		
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));
	}

}
