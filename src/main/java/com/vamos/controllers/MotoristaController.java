package com.vamos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamos.models.Motorista;
import com.vamos.services.MotoristaService;

@RestController
@RequestMapping(value = "/motoristas")
public class MotoristaController {
	
	@Autowired
	private MotoristaService motoristaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Motorista> find (@PathVariable Integer id){
		Motorista obj = motoristaService.find(id);
		return ResponseEntity.ok().body(obj);	
	}

}
