package org.example.greenshadowsystem.controller;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dto.FieldStatus;
import org.example.greenshadowsystem.dto.impl.FieldDTO;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.FieldNotFoundException;
import org.example.greenshadowsystem.service.FieldService;
import org.example.greenshadowsystem.util.AppUtil;
import org.example.greenshadowsystem.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/field")
public class FieldController {
    @Autowired
    private FieldService fieldService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("fieldName") String fieldName,
            /*@RequestPart("longitude") double longitude,
            @RequestPart("latitude") double latitude,*/
            @RequestPart("location") String location,
            @RequestPart("size") String size,
            @RequestPart("img1") MultipartFile img1,
            @RequestPart("img2") MultipartFile img2

    ){
        System.out.println("sdsd");
        String base64Pic1 =";";
        String base64Pic2 =";";
        //profilePic --> Base64

        try {
            byte[] bytesPic1 =img1.getBytes();
            byte[] bytesPic2 =img2.getBytes();
            base64Pic1 = AppUtil.profilePicToBase64(bytesPic1);
            base64Pic2 = AppUtil.profilePicToBase64(bytesPic2);

            String fieldId = AppUtil.generateFieldId();

            var buildFieldDTO = new FieldDTO();
            buildFieldDTO.setFieldCode(fieldId);
            buildFieldDTO.setFieldName(fieldName);
            buildFieldDTO.setLocation(location);
            //buildFieldDTO.setLocation(new Point(longitude, latitude));
            buildFieldDTO.setSize(size);
            buildFieldDTO.setImg1(base64Pic1);
            buildFieldDTO.setImg2(base64Pic2);
            fieldService.saveField(buildFieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping(value = "/{fieldCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldStatus getSelectedField(@PathVariable ("fieldCode") String fieldId){
        if(!RegexProcess.fieldIdMatcher(fieldId)){
            return new SelectedCustomErrorStatus(1,"Field is not valid");
        }
        return fieldService.getField(fieldId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{fieldCode}")
    public ResponseEntity<Void> deleteField(@PathVariable ("fieldCode") String fieldId){
        try{
            if(!RegexProcess.fieldIdMatcher(fieldId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            fieldService.deleteField(fieldId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (FieldNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDTO> getAllField(){
        return fieldService.getAllField();
    }

    @PutMapping(value = "/{fieldCode}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateField(FieldDTO fieldDTO,
                           @RequestPart("fieldName") String fieldName,
                           @RequestPart("location") String location,
                           @RequestPart("size") String size,
                           @RequestPart("img1") MultipartFile img1,
                           @RequestPart("img2") MultipartFile img2,
                           @PathVariable ("fieldCode") String fieldId)
    {
        String base64Pic1 =";";
        String base64Pic2 =";";
        //profilePic --> Base64

        try {
            byte[] bytesProfilePic1 =img1.getBytes();
            byte[] bytesProfilePic2 =img2.getBytes();
            base64Pic1 = AppUtil.profilePicToBase64(bytesProfilePic1);
            base64Pic2 = AppUtil.profilePicToBase64(bytesProfilePic2);
        }catch (IOException e){
            throw new RuntimeException(e);
        }



        var buildFieldDTO = new FieldDTO();
        buildFieldDTO.setFieldCode(fieldId);
        buildFieldDTO.setFieldName(fieldName);
        buildFieldDTO.setLocation(location);
        buildFieldDTO.setSize(size);
        buildFieldDTO.setImg1(base64Pic1);
        buildFieldDTO.setImg2(base64Pic2);
        fieldService.updateField(fieldId,buildFieldDTO);

    }
}
