package com.vamos.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vamos.domain.Motorista;
import com.vamos.dto.MotoristaDTO;
import com.vamos.dto.MotoristaNewDTO;
import com.vamos.services.MotoristaService;

@RestController
@RequestMapping(value = "/motoristas")
public class MotoristaResource {
	
	@Autowired
	private MotoristaService motoristaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Motorista> find(@PathVariable Integer id){
		Motorista obj = motoristaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/email")
	public ResponseEntity<Motorista> find(@RequestParam(value="value") String email){
		Motorista obj = motoristaService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody MotoristaNewDTO objDTO){
		Motorista obj = motoristaService.fromDTO(objDTO);
		obj = motoristaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update( @Valid @RequestBody MotoristaDTO objDTO, @PathVariable Integer id){
		Motorista obj = motoristaService.fromDTO(objDTO);
		obj.setId(id);
		obj = motoristaService.update(obj);
		return ResponseEntity.noContent().build();
	}

}
