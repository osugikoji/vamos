package com.vamos.services;

import com.vamos.domain.Student;
import com.vamos.repositories.AddressRepository;
import com.vamos.repositories.StudentRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public Student find(Integer id) {
		
		Optional<Student> obj = studentRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Student.class.getName()));
	}
	
	public Student findByEmail(String email) {
		Student obj = studentRepository.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +  ", Tipo: " + Student.class.getName());
		}
		return obj;
	}
	
	@Transactional
	public Student insert(Student obj) {
		obj.setId(null);
		obj = studentRepository.save(obj);
		//addressRepository.saveAll(obj.getAddresses());
		return obj;
	}
	
	public Student update(Student obj) {
		Student newObj = find(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setBirthDate(obj.getBirthDate());
		newObj.setInstitution(obj.getInstitution());
		return studentRepository.save(newObj);
	}
}
