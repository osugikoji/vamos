package com.vamos.services;

import com.vamos.domain.Student;
import com.vamos.domain.VanGroup;
import com.vamos.dto.output.GroupDetailsDTO;
import com.vamos.repositories.GroupRepository;
import com.vamos.repositories.StudentRepository;
import com.vamos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    public GroupDetailsDTO findGroup(Integer id) {
        Optional<VanGroup> group = groupRepository.findById(id);

        if (group == null) {
            new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + GroupDetailsDTO.class.getName());
        }

        return new GroupDetailsDTO(group.get());
    }

    public List<GroupDetailsDTO> findDriverGroups(Integer id) {
        List<VanGroup> listGroup = groupRepository.findGroupsByDriverId(id);

        if (listGroup == null) {
            new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + VanGroup.class.getName());
        }

        List<GroupDetailsDTO> vanGroups = new ArrayList<>();
        for (VanGroup group : listGroup) {
            vanGroups.add(new GroupDetailsDTO(group));
        }

        return vanGroups;
    }

    public List<GroupDetailsDTO> findStudentGroups(Integer id) {
        Optional<Student> student1 = studentRepository.findById(id);
        Student student = student1.get();
        Set<VanGroup> studentGroups = student.getGroups();

        if (student == null) {
            new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Student.class.getName());
        }

        if (studentGroups.size() == 0) {
            new Exception("Objeto não encontrado! Id: " + id + ", Tipo: " + Student.class.getName());
        }

        List<GroupDetailsDTO> vanGroups = new ArrayList<>();
        for (VanGroup group : studentGroups) {
            vanGroups.add(new GroupDetailsDTO(group));
        }

        return vanGroups;
    }

    @Transactional
    public VanGroup insert(VanGroup obj) {
        obj.setId(null);
        obj = groupRepository.save(obj);
        return obj;
    }
}
