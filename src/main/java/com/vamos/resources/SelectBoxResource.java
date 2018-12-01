package com.vamos.resources;

import com.vamos.dto.output.SelectBoxDTO;
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
    public ResponseEntity<List<SelectBoxDTO>> findAllStates(){
        List<SelectBoxDTO> selectBoxDTOs = selectBoxService.findAllStates();
        return ResponseEntity.ok().body(selectBoxDTOs);
    }

    /**
     * Busca todas as cidades do estado correspondente
     *
     * @param stateId id do estado
     * @return as cidades
     */

    @GetMapping("/citiesByState")
    public ResponseEntity<List<SelectBoxDTO>> findAllCitiesByState(@RequestParam(value="value") Integer stateId){
        List<SelectBoxDTO> selectBoxDTOs = selectBoxService.findAllCitiesByState(stateId);
        return ResponseEntity.ok().body(selectBoxDTOs);
    }

    @GetMapping("/institutions")
    public ResponseEntity<List<SelectBoxDTO>> findAllInstitutions(){
        List<SelectBoxDTO> selectBoxDTOs = selectBoxService.findAllInstitutions();
        return ResponseEntity.ok().body(selectBoxDTOs);
    }
}
