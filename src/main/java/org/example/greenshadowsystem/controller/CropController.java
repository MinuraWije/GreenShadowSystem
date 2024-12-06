package org.example.greenshadowsystem.controller;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dto.CropStatus;
import org.example.greenshadowsystem.dto.impl.CropDTO;
import org.example.greenshadowsystem.exception.CropNotFoundException;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.service.CropService;
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
@RequestMapping("api/v1/crop")
public class CropController {
    @Autowired
    private CropService cropService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("cropName") String cropName,
            @RequestPart("cropScientificName") String cropScientificName,
            @RequestPart("category") String category,
            @RequestPart("img") MultipartFile img,
            @RequestPart("season") String season

    ){
        String base64Pic1 =";";
        //profilePic --> Base64

        try {
            byte[] bytesPic1 =img.getBytes();
            base64Pic1 = AppUtil.profilePicToBase64(bytesPic1);

            String cropId = AppUtil.generateCropId();

            var buildCropDTO = new CropDTO();
            buildCropDTO.setCropCode(cropId);
            buildCropDTO.setCropName(cropName);
            buildCropDTO.setCropScientificName(cropScientificName);
            buildCropDTO.setCategory(category);
            buildCropDTO.setImg(base64Pic1);
            buildCropDTO.setSeason(season);
            cropService.saveCrop(buildCropDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping(value = "/{cropCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CropStatus getSelectedCrop(@PathVariable("cropCode") String cropId){
        if(!RegexProcess.cropIdMatcher(cropId)){
            return new SelectedCustomErrorStatus(1,"Crop is not valid");
        }
        return cropService.getCrop(cropId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{cropCode}")
    public ResponseEntity<Void> deleteCrop(@PathVariable ("cropCode") String cropId){
        try{
            if(!RegexProcess.cropIdMatcher(cropId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cropService.deleteCrop(cropId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CropNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropDTO> getAllCrop(){
        return cropService.getAllCrop();
    }

    @PutMapping(value = "/{cropCode}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateCrop(CropDTO cropDTO,
                            @RequestPart("cropName") String cropName,
                            @RequestPart("cropScientificName") String cropScientificName,
                            @RequestPart("category") String category,
                            @RequestPart("img") MultipartFile img,
                            @RequestPart("season") String season,
                            @PathVariable ("cropCode") String cropId)
    {
        String base64Pic1 =";";
        //profilePic --> Base64

        try {
            byte[] bytesProfilePic1 =img.getBytes();
            base64Pic1 = AppUtil.profilePicToBase64(bytesProfilePic1);
        }catch (IOException e){
            throw new RuntimeException(e);
        }


        var buildCropDTO = new CropDTO();
        buildCropDTO.setCropCode(cropId);
        buildCropDTO.setCropName(cropName);
        buildCropDTO.setCropScientificName(cropScientificName);
        buildCropDTO.setCategory(category);
        buildCropDTO.setImg(base64Pic1);
        buildCropDTO.setSeason(season);
        cropService.updateCrop(cropId,buildCropDTO);

    }
}
