package com.vamos.resources;

import com.vamos.dto.get.CityDTO;
import com.vamos.dto.get.InstitutionDTO;
import com.vamos.dto.get.StateDTO;
import com.vamos.services.SelectBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/selectBoxes")
public class SelectBoxResource {

    @Autowired
    private SelectBoxService selectBoxService;

    /**
     * Busca todos os estados
     *
     * @return os estados
     */
    @GetMapping("/states")
    public ResponseEntity<List<StateDTO>> findAllStates(){
        List<StateDTO> objList = selectBoxService.findAllStates();
        return ResponseEntity.ok().body(objList);
    }

    /**
     * Busca todas as cidades do estado correspondente
     *
     * @param state o estado
     * @return as cidades
     */

    @GetMapping("/citiesByState")
    public ResponseEntity<List<CityDTO>> findAllCitiesByState(@RequestParam(value="value") String state){
        List<CityDTO> objList = selectBoxService.findAllCitiesByState(state);
        return ResponseEntity.ok().body(objList);
    }

    @GetMapping("/institutions")
    public ResponseEntity<List<InstitutionDTO>> findAllInstitutions(){
        List<InstitutionDTO> objList = selectBoxService.findAllInstitutions();
        return ResponseEntity.ok().body(objList);
    }
}
