package org.example.greenshadowsystem.util;


import org.example.greenshadowsystem.dto.impl.EquipmentDTO;
import org.example.greenshadowsystem.dto.impl.FieldDTO;
import org.example.greenshadowsystem.dto.impl.StaffDTO;
import org.example.greenshadowsystem.dto.impl.VehicleDTO;
import org.example.greenshadowsystem.entity.impl.EquipmentEntity;
import org.example.greenshadowsystem.entity.impl.FieldEntity;
import org.example.greenshadowsystem.entity.impl.StaffEntity;
import org.example.greenshadowsystem.entity.impl.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //for staff mapping
    public StaffEntity toStaffEntity(StaffDTO staffDTO){
        return modelMapper.map(staffDTO,StaffEntity.class);
    }

    public StaffDTO toStaffDTO(StaffEntity staffEntity){
        return modelMapper.map(staffEntity,StaffDTO.class);
    }

    public List<StaffDTO> asStaffDTOList(List<StaffEntity> staffEntities){
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>() {}.getType());
    }
    //for vehicle mapping
    public VehicleDTO toVehicleDTO(VehicleEntity vehicleEntity){
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
    public VehicleEntity toVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }
    public List<VehicleDTO> asVehicleDTOList(List<VehicleEntity> vehicleEntityList){
        return modelMapper.map(vehicleEntityList, new TypeToken<List<VehicleDTO>>() {}.getType());
    }
    //for equipment mapping
    public EquipmentDTO toEquipmentDTO(EquipmentEntity equipmentEntity){
        return modelMapper.map(equipmentEntity, EquipmentDTO.class);
    }
    public EquipmentEntity toEquipmentEntity(EquipmentDTO equipmentDTO){
        return modelMapper.map(equipmentDTO, EquipmentEntity.class);
    }
    public List<EquipmentDTO> asEquipmentDTOList(List<EquipmentEntity> equipmentEntityList){
        return modelMapper.map(equipmentEntityList, new TypeToken<List<EquipmentDTO>>() {}.getType());
    }
    //for field mapping
    public FieldDTO toFieldDTO(FieldEntity fieldEntity){
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public FieldEntity toFieldEntity(FieldDTO fieldDTO){
        return modelMapper.map(fieldDTO, FieldEntity.class);
    }
    public List<FieldDTO> asFieldDTOList(List<FieldEntity> fieldEntityList){
        return modelMapper.map(fieldEntityList, new TypeToken<List<FieldDTO>>() {}.getType());
    }
}
