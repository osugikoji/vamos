package com.vamos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamos.domain.Estudante;
import com.vamos.services.EstudanteService;

@RestController
@RequestMapping(value = "/estudantes")
public class EstudanteResource {
	
	@Autowired
	private EstudanteService estudanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> find(@PathVariable Integer id){
		Estudante obj = estudanteService.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
