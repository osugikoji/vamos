package com.vamos.services;

import com.vamos.domain.City;
import com.vamos.domain.Institution;
import com.vamos.domain.State;
import com.vamos.dto.get.CityDTO;
import com.vamos.dto.get.InstitutionDTO;
import com.vamos.dto.get.StateDTO;
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

	public List<StateDTO> findAllStates(){
		List<State> stateList = stateRepository.findAll();
		if(stateList == null){
			// TODO: 20/11/2018 criar exception
		}

		List<StateDTO> stateDTO = new ArrayList<>();
		for(State state : stateList){
			stateDTO.add(convertStateToStateDTO(state));
		}

		return stateDTO;
	}

	public List<CityDTO> findAllCitiesByState(String state){
		List<City> cityList = cityRepository.findAllByState_Description(state);
		if(cityList == null){
			// TODO: 20/11/2018 criar exception
		}

		List<CityDTO> cityDTO = new ArrayList<>();
		for(City city : cityList){
			cityDTO.add(convertCityToCityDTO(city));
		}

		return cityDTO;
	}

	public List<InstitutionDTO> findAllInstitutions(){
		List<Institution> institutionsList = institutionRepository.findAll();
		if(institutionsList == null){
			// TODO: 20/11/2018 criar exception
		}

		List<InstitutionDTO> institutionDTO = new ArrayList<>();
		for(Institution institution : institutionsList){
			institutionDTO.add(convertInstitutionToInstitutionDTO(institution));
		}

		return institutionDTO;
	}

	private StateDTO convertStateToStateDTO(State state){
		StateDTO stateDTO = new StateDTO();
		stateDTO.setState(state.getDescription());
		return stateDTO;
	}

	private CityDTO convertCityToCityDTO(City city){
		CityDTO cityDTO = new CityDTO();
		cityDTO.setCity(city.getDescription());
		return cityDTO;
	}

	private InstitutionDTO convertInstitutionToInstitutionDTO(Institution institution){
		InstitutionDTO institutionDTO = new InstitutionDTO();
		institutionDTO.setInstitution(institution.getDescription());
		return institutionDTO;
	}
}
