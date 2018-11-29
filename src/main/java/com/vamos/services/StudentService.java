package com.vamos.services;

import com.vamos.domain.DailySchedule;
import com.vamos.domain.Institution;
import com.vamos.domain.Student;
import com.vamos.dto.input.NewStudentDTO;
import com.vamos.dto.input.UpdateStudentDTO;
import com.vamos.repositories.AddressRepository;
import com.vamos.repositories.DailyScheduleRepository;
import com.vamos.repositories.InstitutionRepository;
import com.vamos.repositories.StudentRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private InstitutionRepository institutionRepository;

	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

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
	public Student insert(NewStudentDTO newStudentDTO) {
		Optional<Institution> institution = institutionRepository.findById(Integer.parseInt(newStudentDTO.getInstitutionId()));
		Student obj = new Student(null, newStudentDTO.getName(), newStudentDTO.getEmail(), bCryptPasswordEncoder.encode(newStudentDTO.getPassword()),
				null, institution.get(), null);
		obj = studentRepository.save(obj);
		//addressRepository.saveAll(obj.getAddresses());
		return obj;
	}
	
	public Student update(UpdateStudentDTO objDTO, Integer id) {
		Student newObj = find(id);
		Optional<Institution> institution = institutionRepository.findById(objDTO.getInstitutionId());
		newObj.setName(objDTO.getName());
		newObj.setEmail(objDTO.getEmail());
		newObj.setBirthDate(objDTO.getBirthDate());
		newObj.setInstitution(institution.get());
		return studentRepository.save(newObj);
	}

	public List<DailySchedule> findStudentSchedule(Integer id){
		List<DailySchedule> dailySchedules = dailyScheduleRepository.findAllByStudent_Id(id);
		return dailySchedules;
	}
}
