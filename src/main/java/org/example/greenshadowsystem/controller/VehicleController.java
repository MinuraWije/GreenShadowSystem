package org.example.greenshadowsystem.controller;


import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dto.VehicleStatus;
import org.example.greenshadowsystem.dto.impl.VehicleDTO;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.VehicleNotFoundException;
import org.example.greenshadowsystem.service.VehicleService;
import org.example.greenshadowsystem.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        try{
            vehicleService.saveVehicle(vehicleDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{vehicleCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public VehicleStatus getSelectedVehicle(@PathVariable ("vehicleCode") String vehicleId){
        if(!RegexProcess.vehicleIdMatcher(vehicleId)){
            return new SelectedCustomErrorStatus(1,"Vehicle id is not valid");
        }
        return vehicleService.getVehicle(vehicleId);
    }
    public List<VehicleDTO> getAllVehicles(){
        return null;
    }
    @DeleteMapping(value = "{vehicleCode}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable ("vehicleCode") String vehicleId){
        try{
            if(!RegexProcess.vehicleIdMatcher(vehicleId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            vehicleService.deleteVehicle(vehicleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(VehicleNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value = "{vehicleCode}")
    public ResponseEntity<Void> updateVehicle(@PathVariable ("vehicleCode") String vehicleId,@RequestBody VehicleDTO updatedVehicleDTO){
        //validations
        try {
            if(!RegexProcess.vehicleIdMatcher(vehicleId) || updatedVehicleDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            vehicleService.updateVehicle(vehicleId,updatedVehicleDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
