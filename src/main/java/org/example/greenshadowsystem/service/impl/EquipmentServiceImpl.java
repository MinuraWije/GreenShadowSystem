package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dao.EquipmentDao;
import org.example.greenshadowsystem.dto.EquipmentStatus;
import org.example.greenshadowsystem.dto.impl.EquipmentDTO;
import org.example.greenshadowsystem.entity.impl.EquipmentEntity;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.EquipmentNotFoundException;
import org.example.greenshadowsystem.service.EquipmentService;
import org.example.greenshadowsystem.util.AppUtil;
import org.example.greenshadowsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;
    @Autowired
    private Mapping equipmentMapping;
    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO){
        equipmentDTO.setEquipmentId(AppUtil.generateEquipmentId());
        EquipmentEntity savedEquipment = equipmentDao.save(equipmentMapping.toEquipmentEntity(equipmentDTO));
        if(savedEquipment == null){
            throw new DataPersistException("Equipment not saved.");
        }
    }

    @Override
    public List<EquipmentDTO> getAllEquipment() {
        return equipmentMapping.asEquipmentDTOList(equipmentDao.findAll());
    }

    @Override
    public EquipmentStatus getEquipment(String equipmentId) {
        if(equipmentDao.existsById(equipmentId)){
            var selectedEquipment = equipmentDao.getReferenceById(equipmentId);
            return equipmentMapping.toEquipmentDTO(selectedEquipment);
        }
        return new SelectedCustomErrorStatus(2, "Selected equipment not found.");
    }

    @Override
    public void deleteEquipment(String equipmentId) {
        Optional<EquipmentEntity> foundEquipment = equipmentDao.findById(equipmentId);
        if(!foundEquipment.isPresent()){
            throw new EquipmentNotFoundException("Equipment not found.");
        }else{
            equipmentDao.deleteById(equipmentId);
        }
    }

    @Override
    public void updateEquipment(String equipmentId, EquipmentDTO equipmentDTO) {
        Optional<EquipmentEntity> findEquipment = equipmentDao.findById(equipmentId);
        if(!findEquipment.isPresent()){
            throw new EquipmentNotFoundException("Equipment not found");
        }else {
            findEquipment.get().setName(equipmentDTO.getName());
            findEquipment.get().setType(equipmentDTO.getType());
            findEquipment.get().setStatus(equipmentDTO.getStatus());
        }
    }
}
