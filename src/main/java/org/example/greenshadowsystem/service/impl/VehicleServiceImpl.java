package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.VehicleNotFoundException;
import org.example.greenshadowsystem.dto.VehicleStatus;
import org.example.greenshadowsystem.entity.impl.VehicleEntity;
import org.example.greenshadowsystem.util.AppUtil;
import org.example.greenshadowsystem.dto.impl.VehicleDTO;
import org.example.greenshadowsystem.util.Mapping;
import org.example.greenshadowsystem.dao.VehicleDao;
import org.example.greenshadowsystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private Mapping vehicleMapping;
    /*private static List<NoteDTO> noteDTOList = new ArrayList<>();

    NoteServiceImpl(){
        noteDTOList.add(new NoteDTO())
    }*/
    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setVehicleCode(AppUtil.generateVehicleId());
        VehicleEntity savedVehicle = vehicleDao.save(vehicleMapping.toVehicleEntity(vehicleDTO));
        if(savedVehicle == null){
            throw new DataPersistException("Vehicle not saved.");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleMapping.asVehicleDTOList(vehicleDao.findAll());
    }

    @Override
    public VehicleStatus getVehicle(String vehicleId) {
        if(vehicleDao.existsById(vehicleId)){
            var selectedNote = vehicleDao.getReferenceById(vehicleId);
            return vehicleMapping.toVehicleDTO(selectedNote);
        }
        return new SelectedCustomErrorStatus(2, "Selected Vehicle not found.");
    }

    @Override
    public void deleteVehicle(String vehicleId) {
        Optional<VehicleEntity> foundVehicle = vehicleDao.findById(vehicleId);
        if(!foundVehicle.isPresent()){
            throw new VehicleNotFoundException("Vehicle not found.");
        }else{
            vehicleDao.deleteById(vehicleId);
        }
    }

    @Override
    public void updateVehicle(String vehicleId, VehicleDTO vehicleDTO) {
        Optional<VehicleEntity> findVehicle = vehicleDao.findById(vehicleId);
        if(!findVehicle.isPresent()){
            throw new VehicleNotFoundException("Vehicle not found");
        }else {
            findVehicle.get().setLicensePlateNum(vehicleDTO.getLicensePlateNum());
            findVehicle.get().setCategory(vehicleDTO.getCategory());
            findVehicle.get().setFuelType(vehicleDTO.getFuelType());
            findVehicle.get().setStatus(vehicleDTO.getStatus());
        }
    }
}
