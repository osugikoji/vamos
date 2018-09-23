package com.vamos.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamos.domain.Endereco;
import com.vamos.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	private EnderecoService enderecoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> find (@PathVariable long id){
		Endereco obj = enderecoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
