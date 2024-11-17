package org.example.greenshadowsystem.service;

import org.example.greenshadowsystem.dto.EquipmentStatus;
import org.example.greenshadowsystem.dto.impl.EquipmentDTO;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDTO equipmentDTO);
    List<EquipmentDTO> getAllEquipment();
    EquipmentStatus getEquipment(String equipmentDTO);
    void deleteEquipment(String equipmentId);
    void updateEquipment(String equipmentId,EquipmentDTO equipmentDTO);
}
