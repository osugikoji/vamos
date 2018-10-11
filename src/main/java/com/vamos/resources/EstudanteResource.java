package com.vamos.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vamos.domain.Estudante;
import com.vamos.dto.EstudanteNewDTO;
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
	
	@GetMapping("/email")
	public ResponseEntity<Estudante> find(@RequestParam(value="value") String email){
		Estudante obj = estudanteService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Estudante> insert(@RequestBody EstudanteNewDTO objDTO){
		Estudante obj = estudanteService.fromDTO(objDTO);
		obj = estudanteService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
