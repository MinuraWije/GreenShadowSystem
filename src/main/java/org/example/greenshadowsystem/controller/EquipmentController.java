package org.example.greenshadowsystem.controller;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dto.EquipmentStatus;
import org.example.greenshadowsystem.dto.impl.EquipmentDTO;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.EquipmentNotFoundException;
import org.example.greenshadowsystem.service.EquipmentService;
import org.example.greenshadowsystem.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/v1/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        try{
            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{equipmentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EquipmentStatus getSelectedEquipment(@PathVariable ("equipmentId") String equipmentId){
        if(!RegexProcess.equipmentIdMatcher(equipmentId)){
            return new SelectedCustomErrorStatus(1,"Equipment id is not valid");
        }
        return equipmentService.getEquipment(equipmentId);
    }
    @GetMapping
    public List<EquipmentDTO> getAllEquipment(){
        return equipmentService.getAllEquipment();
    }
    @DeleteMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable ("equipmentId") String equipmentId){
        try{
            if(!RegexProcess.equipmentIdMatcher(equipmentId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            equipmentService.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(EquipmentNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> updateEquipment(@PathVariable ("equipmentId") String equipmentId, @RequestBody EquipmentDTO updatedEquipmentDTO){
        //validations
        try {
            if(!RegexProcess.equipmentIdMatcher(equipmentId) || updatedEquipmentDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            equipmentService.updateEquipment(equipmentId,updatedEquipmentDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

