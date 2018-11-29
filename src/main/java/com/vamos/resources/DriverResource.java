package com.vamos.resources;

import com.vamos.domain.Driver;
import com.vamos.dto.input.NewDriverDTO;
import com.vamos.dto.input.UpdateDriverDTO;
import com.vamos.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/drivers")
public class DriverResource {

    @Autowired
    private DriverService driverService;

    /**
     * Busca um motorista atraves do id
     *
     * @param id do motorista
     * @return o motorista
     */
    @GetMapping("/{id}")
    public ResponseEntity<Driver> find(@PathVariable Integer id) {
        Driver obj = driverService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Busca um motorista atraves do email
     *
     * @param email do motorista
     * @return o motorista
     */
    @GetMapping("/email")
    public ResponseEntity<Driver> find(@RequestParam(value = "value") String email) {
        Driver obj = driverService.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Cadastro de motorista
     *
     * @param objDTO todos os atributos necessarios para cadastrar um motorista
     * @return nada
     */
    @PostMapping()
    public ResponseEntity<Void> insert(@Valid @RequestBody NewDriverDTO objDTO) {
        Driver obj = driverService.insert(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * Atualiza as informacoes do motorista
     *
     * @param objDTO contem atributos do motorista que serao atualizados
     * @param id     do motorista
     * @return nada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UpdateDriverDTO objDTO, @PathVariable Integer id) {
        Driver obj = objDTO.convertToEntity();
        obj.setId(id);
        obj = driverService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
