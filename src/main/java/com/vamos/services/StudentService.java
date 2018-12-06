package com.vamos.services;

import com.vamos.domain.*;
import com.vamos.dto.input.NewStudentDTO;
import com.vamos.dto.input.UpdateStudentDTO;
import com.vamos.dto.output.StudentDTO;
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
	private AddressRepository addressRepository;

	@Autowired
	private InstitutionRepository institutionRepository;

	@Autowired
	private DailyScheduleRepository dailyScheduleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public StudentDTO find(Integer id) {
		
		Optional<Student> student = studentRepository.findById(id);

		if(student == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +  ", Tipo: " + Student.class.getName());
		}

		Student obj = student.get();

		Address address = obj.getAddresses().iterator().next();
		StudentDTO objDTO = new StudentDTO(obj.getName(),obj.getEmail(),obj.getPhones().iterator().next(),obj.getInstitution().getDescription(),
				address.getStreet(),address.getNumber(),address.getComplement(),address.getDistrict(),address.getCity().getDescription());

		return objDTO;
	}
	
	public StudentDTO findByEmail(String email) {
		Student obj = studentRepository.findByEmail(email);

		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +  ", Tipo: " + Student.class.getName());
		}

		Address address = obj.getAddresses().iterator().next();
		StudentDTO objDTO = new StudentDTO(obj.getName(),obj.getEmail(),obj.getPhones().iterator().next(),obj.getInstitution().getDescription(),
				address.getStreet(),address.getNumber(),address.getComplement(),address.getDistrict(),address.getCity().getDescription());

		return objDTO;
	}
	
	@Transactional
	public Student insert(NewStudentDTO newStudentDTO) {
		Institution institution = new Institution(Integer.parseInt(newStudentDTO.getInstitutionId()), null);
		State state = new State(Integer.parseInt(newStudentDTO.getStateId()), null);
		City city = new City(Integer.parseInt(newStudentDTO.getCityId()), null, state);
		Student student = new Student(null, newStudentDTO.getName(), newStudentDTO.getEmail(), bCryptPasswordEncoder.encode(newStudentDTO.getPassword()),
				null, institution, null);
		Address address = new Address(null, newStudentDTO.getStreet(), newStudentDTO.getNumber(), null, newStudentDTO.getDistrict(), city, student);
		student = studentRepository.save(student);
		addressRepository.save(address);
		return student;
	}
	
	public Student update(UpdateStudentDTO objDTO, Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		Student newObj = student.get();
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
