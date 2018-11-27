package com.vamos.resources;

import com.vamos.domain.DailySchedule;
import com.vamos.domain.Student;
import com.vamos.dto.input.UpdateStudentDTO;
import com.vamos.dto.input.NewStudentDTO;
import com.vamos.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
	public ResponseEntity<Void> insert(@Valid @RequestBody NewStudentDTO objDTO){
		Student obj = studentService.insert(objDTO);
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
	public ResponseEntity<Void> update(@Valid @RequestBody UpdateStudentDTO objDTO, @PathVariable Integer id){
		Student obj = studentService.update(objDTO, id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Busca a programacao da semana do estudante
	 *
	 * @param id do estudante
	 * @return as programacoes dos dias
	 */
	@GetMapping("findStudentSchedule/{id}")
	public ResponseEntity<List<DailySchedule>> findStudentSchedule(@PathVariable Integer id){
		List<DailySchedule> dailySchedules = studentService.findStudentSchedule(id);
		return ResponseEntity.ok().body(dailySchedules);
	}
}
