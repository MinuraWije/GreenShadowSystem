package org.example.greenshadowsystem.service;

import org.example.greenshadowsystem.dto.CropStatus;
import org.example.greenshadowsystem.dto.impl.CropDTO;

import java.util.List;

public interface CropService {
    void saveCrop(CropDTO cropDTO);
    List<CropDTO> getAllCrop();
    CropStatus getCrop(String cropDTO);
    void deleteCrop(String cropId);
    void updateCrop(String cropId,CropDTO cropDTO);
}
