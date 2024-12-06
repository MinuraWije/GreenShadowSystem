package org.example.greenshadowsystem.controller;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dto.StaffStatus;
import org.example.greenshadowsystem.dto.impl.StaffDTO;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.StaffNotFoundException;
import org.example.greenshadowsystem.service.StaffService;
import org.example.greenshadowsystem.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(@RequestBody StaffDTO staffDTO) {
        try{
            staffService.saveStaff(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{staffId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffStatus getSelectedStaff(@PathVariable ("staffId") String staffId){
        if(!RegexProcess.staffIdMatcher(staffId)){
            return new SelectedCustomErrorStatus(1,"Staff id is not valid");
        }
        return staffService.getStaff(staffId);
    }
    @GetMapping
    public List<StaffDTO> getAllStaff(){
        return staffService.getAllStaff();
    }
    @DeleteMapping(value = "/{staffId}")
    public ResponseEntity<Void> deleteStaff(@PathVariable ("staffId") String staffId){
        try{
            if(!RegexProcess.staffIdMatcher(staffId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            staffService.deleteStaff(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(StaffNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping(value = "/{staffId}")
    public ResponseEntity<Void> updateStaff(@PathVariable ("staffId") String staffId,@RequestBody StaffDTO updatedStaffDTO){
        //validations
        try {
            if(!RegexProcess.staffIdMatcher(staffId) || updatedStaffDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            staffService.updateStaff(staffId,updatedStaffDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
