package com.vamos.resources;

import com.vamos.domain.Student;
import com.vamos.dto.StudentUpdateDTO;
import com.vamos.dto.StudentNewDTO;
import com.vamos.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/students")
public class StudentResource {
	
	@Autowired
	private StudentService studentService;

	/**
	 * Busca um estudante atraves do id
	 *
	 * @param id do estudante
	 * @return o estudante
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Student> find(@PathVariable Integer id){
		Student obj = studentService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Busca um estudante atraves do email
	 *
	 * @param email do estudante
	 * @return o estudante
	 */
	@GetMapping("/email")
	public ResponseEntity<Student> find(@RequestParam(value="value") String email){
		Student obj = studentService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Cadastro de estudante
	 *
	 * @param objDTO todos os atributos necessarios para cadastrar um estudante
	 * @return nada
	 */
	@PostMapping()
	public ResponseEntity<Void> insert(@Valid @RequestBody StudentNewDTO objDTO){
		Student obj = objDTO.convertToEntity();
		obj = studentService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	/**
	 * Atualiza os dados do estudante
	 *
	 * @param objDTO contem atributos do estudante que serao atualizados
	 * @param id do estudante
	 * @return nada
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody StudentUpdateDTO objDTO, @PathVariable Integer id){
		Student obj = objDTO.convertToEntity();
		obj.setId(id);
		obj = studentService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
