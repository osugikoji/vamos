package com.vamos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vamos.domain.Driver;
import com.vamos.repositories.DriverRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;


@Service
public class DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	public Driver find(Integer id) {
		
		Optional<Driver> obj = driverRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Driver.class.getName()));
	}
	
	public Driver findByEmail(String email) {
		Driver obj = driverRepository.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " +  ", Tipo: " + Driver.class.getName());
		}
		return obj;
	}
	
	@Transactional
	public Driver insert(Driver obj) {
		obj.setId(null);
		obj = driverRepository.save(obj);
		return obj;
	}
	
	public Driver update(Driver obj) {
		Driver newObj = find(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		newObj.setBirthDate(obj.getBirthDate());
		return driverRepository.save(newObj);
	}
}
