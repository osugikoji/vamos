package com.vamos.resources;

import com.vamos.domain.VanGroup;
import com.vamos.dto.output.GroupDetailsDTO;
import com.vamos.dto.input.NewGroupDTO;
import com.vamos.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class GroupResource {

    @Autowired
    private GroupService groupService;

    /**
     * Busca um grupo específico
     *
     * @param id do grupo
     * @return o grupo
     */
    @GetMapping("/{id}")
    public ResponseEntity<GroupDetailsDTO> findGroup(@PathVariable Integer id){
        GroupDetailsDTO obj = groupService.findGroup(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Busca todos os grupos que o estudante participa
     *
     * @param id do estudante
     * @return os grupos do estudante
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<List<GroupDetailsDTO>> findStudentGroups(@PathVariable Integer id){
        List<GroupDetailsDTO> list = groupService.findStudentGroups(id);
        return ResponseEntity.ok().body(list);
    }

    /**
     * Busca todos os grupos que o motorista participa
     *
     * @param id do motorista
     * @return os grupos do motorista
     */
    @GetMapping("/driver/{id}")
    public ResponseEntity<List<GroupDetailsDTO>> findDriverGroups(@PathVariable Integer id){
        List<GroupDetailsDTO> list = groupService.findDriverGroups(id);
        return ResponseEntity.ok().body(list);
    }

    /**
     * Cria um grupo
     *
     * @param id do motorista
     * @param objDTO contem as informacoes do grupo
     * @return nada
     */
    @PostMapping("/driver/{id}")
    public ResponseEntity<Void> insertGroup(@PathVariable Integer id, @Valid @RequestBody NewGroupDTO objDTO){
        VanGroup obj = objDTO.convertToEntity(id);
        obj = groupService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
