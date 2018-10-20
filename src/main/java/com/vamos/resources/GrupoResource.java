package com.vamos.resources;

import com.vamos.domain.Grupo;
import com.vamos.dto.GrupoNewDTO;
import com.vamos.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/grupos")
public class GrupoResource {

    @Autowired
    private GrupoService grupoService;

    /**
     * Busca um grupo
     *
     * @param id do grupo
     * @return o grupo
     */
    @GetMapping("/{id}")
    public ResponseEntity<Grupo> findGrupo(@PathVariable Integer id){
        Grupo obj = grupoService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Busca todos os grupos que o estudante participa
     *
     * @param id do estudante
     * @return os grupos do estudante
     */
    @GetMapping("/estudante/{id}")
    public ResponseEntity<List<Grupo>> findGruposEstudante(@PathVariable Integer id){
        List<Grupo> list = grupoService.findGruposByEstudanteId(id);
        return ResponseEntity.ok().body(list);
    }

    /**
     * Busca todos os grupos que o motorista participa
     *
     * @param id do motorista
     * @return os grupos do motorista
     */
    @GetMapping("/motorista/{id}")
    public ResponseEntity<List<Grupo>> findGrouposMotorista(@PathVariable Integer id){
        List<Grupo> list = grupoService.findGrouposByMotoristaId(id);
        return ResponseEntity.ok().body(list);
    }

    /**
     * Cria um grupo do motorista
     *
     * @param id do motorista
     * @param objDTO contem as informacoes do grupo
     * @return nada
     */
    @PostMapping("/motorista/{id}")
    public ResponseEntity<Void> insertGrupo(@PathVariable Integer id, @Valid @RequestBody GrupoNewDTO objDTO){
        Grupo obj = grupoService.fromDTO(id,objDTO);
        obj = grupoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
