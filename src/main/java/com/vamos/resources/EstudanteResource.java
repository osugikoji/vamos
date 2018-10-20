package com.vamos.resources;

import com.vamos.domain.Estudante;
import com.vamos.dto.EstudanteDTO;
import com.vamos.dto.EstudanteNewDTO;
import com.vamos.services.EstudanteService;
import com.vamos.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/estudantes")
public class EstudanteResource {
	
	@Autowired
	private EstudanteService estudanteService;

	@Autowired
	private GrupoService grupoService;

	/**
	 * Busca um estudante atraves do id
	 *
	 * @param id do estudante
	 * @return o estudante
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> find(@PathVariable Integer id){
		Estudante obj = estudanteService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Busca um estudante atraves do email
	 *
	 * @param email do estudante
	 * @return o estudante
	 */
	@GetMapping("/email")
	public ResponseEntity<Estudante> find(@RequestParam(value="value") String email){
		Estudante obj = estudanteService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Cadastro de estudante
	 *
	 * @param objDTO todos os atributos necessarios para cadastrar um estudante
	 * @return nada
	 */
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody EstudanteNewDTO objDTO){
		Estudante obj = estudanteService.fromDTO(objDTO);
		obj = estudanteService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Atualiza as informacoes do estudante
	 *
	 * @param objDTO contem atributos do estudante que serao atualizados
	 * @param id do estudante
	 * @return nada
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Void> update( @Valid @RequestBody EstudanteDTO objDTO, @PathVariable Integer id){
		Estudante obj = estudanteService.fromDTO(objDTO);
		obj.setId(id);
		obj = estudanteService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
