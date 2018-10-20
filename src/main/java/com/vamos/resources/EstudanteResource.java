package com.vamos.resources;

import com.vamos.domain.Estudante;
import com.vamos.domain.Grupo;
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
import java.util.List;

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
	 * Insere um estudante na base de dados
	 *
	 * @param objDTO todos os atributos necessarios para construir um estudante
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
	 * @param objDTO atributos do estudante que serao atualizados
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

	@GetMapping("/{id}/grupos")
	public ResponseEntity<List<Grupo>> findGrupos(@PathVariable Integer id){
		List<Grupo> list = grupoService.findGruposByEstudanteId(id);
		return ResponseEntity.ok().body(list);
	}
}
