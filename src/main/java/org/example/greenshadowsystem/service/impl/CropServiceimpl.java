package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dao.CropDao;
import org.example.greenshadowsystem.dto.CropStatus;
import org.example.greenshadowsystem.dto.impl.CropDTO;
import org.example.greenshadowsystem.entity.impl.CropEntity;
import org.example.greenshadowsystem.exception.CropNotFoundException;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.service.CropService;
import org.example.greenshadowsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CropServiceimpl implements CropService {
    @Autowired
    private CropDao cropDao;
    @Autowired
    private Mapping cropMapping;
    @Override
    public void saveCrop(CropDTO cropDTO) {
        CropEntity savedCrop = cropDao.save(cropMapping.toCropEntity(cropDTO));
        if(savedCrop == null){
            throw new DataPersistException("Crop not saved.");
        }
    }

    @Override
    public List<CropDTO> getAllCrop() {
        List<CropEntity> allCrops = cropDao.findAll();
        return cropMapping.asCropDTOList(allCrops);
    }

    @Override
    public CropStatus getCrop(String cropId) {
        if (cropDao.existsById(cropId)) {
            CropEntity selectedCrop = cropDao.getReferenceById(cropId);
            return cropMapping.toCropDTO(selectedCrop);
        } else {
            return new SelectedCustomErrorStatus(2, "Crop not found.");
        }
    }

    @Override
    public void deleteCrop(String cropId) {
        Optional<CropEntity> foundCrop = cropDao.findById(cropId);
        if(!foundCrop.isPresent()){
            throw new CropNotFoundException("Crop not found.");
        }else{
            cropDao.deleteById(cropId);
        }
    }

    @Override
    public void updateCrop(String cropId, CropDTO cropDTO) {
        Optional<CropEntity> findCrop = cropDao.findById(cropId);
        if(!findCrop.isPresent()){
            throw new CropNotFoundException("Crop not found");
        }else {
            findCrop.get().setCropName(cropDTO.getCropName());
            findCrop.get().setCropScientificName(cropDTO.getCropScientificName());
            findCrop.get().setCategory(cropDTO.getCategory());
            findCrop.get().setImg(cropDTO.getImg());
            findCrop.get().setSeason(cropDTO.getSeason());
        }
    }
}
