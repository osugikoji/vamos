package com.vamos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamos.repositories.MotoristaRepository;

@Service
public class DBService {
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	public void instantiateDataBase() {
		
	}

}
