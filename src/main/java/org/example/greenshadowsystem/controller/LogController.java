package org.example.greenshadowsystem.controller;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dto.LogStatus;
import org.example.greenshadowsystem.dto.impl.LogDTO;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.LogNotFoundException;
import org.example.greenshadowsystem.service.LogService;
import org.example.greenshadowsystem.util.AppUtil;
import org.example.greenshadowsystem.util.RegexProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/log")
public class LogController {
    @Autowired
    private LogService logService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveLog(
            @RequestPart("fieldName") String logDetails,
            @RequestPart("location") Date logDate,
            @RequestPart("size") MultipartFile observedImg

    ){
        String base64Pic1 =";";
        //profilePic --> Base64

        try {
            byte[] bytesPic1 =observedImg.getBytes();
            base64Pic1 = AppUtil.profilePicToBase64(bytesPic1);

            String logId = AppUtil.generateLogId();

            var buildLogDTO = new LogDTO();
            buildLogDTO.setLogCode(logId);
            buildLogDTO.setLogDetails(logDetails);
            buildLogDTO.setLogDate(logDate);
            buildLogDTO.setObservedImg(base64Pic1);
            logService.saveLog(buildLogDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping(value = "/{logCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LogStatus getSelectedLog(@PathVariable ("logCode") String logId){
        if(!RegexProcess.logIdMatcher(logId)){
            return new SelectedCustomErrorStatus(1,"Log is not valid");
        }
        return logService.getLog(logId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{logCode}")
    public ResponseEntity<Void> deleteLog(@PathVariable ("logCode") String logId){
        try{
            if(!RegexProcess.logIdMatcher(logId)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            logService.deleteLog(logId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (LogNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LogDTO> getAllLog(){
        return logService.getAllLog();
    }

    @PutMapping(value = "{logCode}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateLog(LogDTO logDTO,
                           @RequestPart("logDetails") String logDetails,
                           @RequestPart("logDate") Date logDate,
                           @RequestPart("observedImg") MultipartFile observedImg,
                           @PathVariable ("logCode") String logId)
    {
        String base64Pic1 =";";
        //profilePic --> Base64

        try {
            byte[] bytesProfilePic1 =observedImg.getBytes();
            base64Pic1 = AppUtil.profilePicToBase64(bytesProfilePic1);
        }catch (IOException e){
            throw new RuntimeException(e);
        }


        var buildLogDTO = new LogDTO();
        buildLogDTO.setLogCode(logId);
        buildLogDTO.setLogDetails(logDetails);
        buildLogDTO.setLogDate(logDate);
        buildLogDTO.setObservedImg(base64Pic1);
        logService.updateLog(logId,buildLogDTO);

    }
}
