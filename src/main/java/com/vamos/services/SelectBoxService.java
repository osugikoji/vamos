package com.vamos.services;

import com.vamos.domain.City;
import com.vamos.domain.Institution;
import com.vamos.domain.State;
import com.vamos.dto.output.SelectBoxDTO;
import com.vamos.repositories.CityRepository;
import com.vamos.repositories.InstitutionRepository;
import com.vamos.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SelectBoxService {

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private InstitutionRepository institutionRepository;

	public List<SelectBoxDTO> findAllStates(){
		List<State> stateList = stateRepository.findAll();
		if(stateList == null){
			// TODO: 20/11/2018 criar exception
		}

		List<SelectBoxDTO> selectBoxDTOs = new ArrayList<>();
		for(State state : stateList){
			selectBoxDTOs.add(new SelectBoxDTO(state.getId().toString(), state.getDescription()));
		}

		return selectBoxDTOs;
	}

	public List<SelectBoxDTO> findAllCitiesByState(Integer stateId){
		List<City> cityList = cityRepository.findAllByState_Id(stateId);
		if(cityList == null){
			// TODO: 20/11/2018 criar exception
		}

		List<SelectBoxDTO> selectBoxDTOs = new ArrayList<>();
		for(City city : cityList){
			selectBoxDTOs.add(new SelectBoxDTO(city.getId().toString(), city.getDescription()));
		}

		return selectBoxDTOs;
	}

	public List<SelectBoxDTO> findAllInstitutions(){
		List<Institution> institutionsList = institutionRepository.findAll();
		if(institutionsList == null){
			// TODO: 20/11/2018 criar exception
		}

		List<SelectBoxDTO> selectBoxDTOs = new ArrayList<>();
		for(Institution institution : institutionsList){
			selectBoxDTOs.add(new SelectBoxDTO(institution.getId().toString(), institution.getDescription()));
		}

		return selectBoxDTOs;
	}
}
