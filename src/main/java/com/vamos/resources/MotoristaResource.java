package com.vamos.resources;

import com.vamos.domain.Motorista;
import com.vamos.dto.MotoristaDTO;
import com.vamos.dto.MotoristaNewDTO;
import com.vamos.services.GrupoService;
import com.vamos.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/motoristas")
public class MotoristaResource {
	
	@Autowired
	private MotoristaService motoristaService;
	
	@Autowired
	private GrupoService grupoService;

	/**
	 * Busca um motorista atraves do id
	 *
	 * @param id do motorista
	 * @return o motorista
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Motorista> find(@PathVariable Integer id){
		Motorista obj = motoristaService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Busca um motorista atraves do email
	 *
	 * @param email do motorista
	 * @return o motorista
	 */
	@GetMapping("/email")
	public ResponseEntity<Motorista> find(@RequestParam(value="value") String email){
		Motorista obj = motoristaService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Cadastro de motorista
	 *
	 * @param objDTO todos os atributos necessarios para cadastrar um motorista
	 * @return nada
	 */
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody MotoristaNewDTO objDTO){
		Motorista obj = motoristaService.fromDTO(objDTO);
		obj = motoristaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Atualiza as informacoes do motorista
	 *
	 * @param objDTO contem atributos do motorista que serao atualizados
	 * @param id do motorista
	 * @return nada
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody MotoristaDTO objDTO, @PathVariable Integer id){
		Motorista obj = motoristaService.fromDTO(objDTO);
		obj.setId(id);
		obj = motoristaService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
