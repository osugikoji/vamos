package com.vamos.services;

import com.vamos.domain.Passenger;
import com.vamos.domain.VanGroup;
import com.vamos.dto.output.GroupDetailsDTO;
import com.vamos.repositories.GroupRepository;
import com.vamos.repositories.PassengerRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private StudentService studentService;
	
	public GroupDetailsDTO findGroup(Integer id) {
		Optional<VanGroup> group = groupRepository.findById(id);

		if(group == null){
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + GroupDetailsDTO.class.getName());
		}

		return convertVanGroupToGroupDetailsDTO(group.get());
	}

	public List<GroupDetailsDTO> findDriverGroups(Integer id) {
		List<VanGroup> listGroup = groupRepository.findGroupsByDriverId(id);

		if(listGroup == null){
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + VanGroup.class.getName());
		}

		List<GroupDetailsDTO> vanGroups = new ArrayList<>();
		for(VanGroup group : listGroup){
			vanGroups.add(convertVanGroupToGroupDetailsDTO(group));
		}

		return vanGroups;
	}

	public List<GroupDetailsDTO> findStudentGroups(Integer id){
		List<Passenger> listPassenger = passengerRepository.findAll(studentService.find(id));

		if(listPassenger == null){
			new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Passenger.class.getName());
		}

		if(listPassenger.size() == 0){
			new Exception ("Objeto não encontrado! Id: " + id + ", Tipo: " + Passenger.class.getName());
		}

		List<GroupDetailsDTO> vanGroups = new ArrayList<>();
		for(Passenger passenger : listPassenger){
			vanGroups.add(convertVanGroupToGroupDetailsDTO(passenger.getGroup()));
		}

		return vanGroups;
	}

	private GroupDetailsDTO convertVanGroupToGroupDetailsDTO(VanGroup group){
		GroupDetailsDTO groupDTO = new GroupDetailsDTO();
		groupDTO.setDriverName(group.getDriver().getName());
		groupDTO.setGroupName(group.getName());
		groupDTO.setInstitution(group.getInstitution().getDescription());
		groupDTO.setMaxCapacity(group.getMaxCapacity());
		groupDTO.setShift(group.getShift().getDescricao());

		return groupDTO;
	}

	@Transactional
	public VanGroup insert(VanGroup obj) {
		obj.setId(null);
		obj = groupRepository.save(obj);
		return obj;
	}
}
