package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dao.FieldDao;
import org.example.greenshadowsystem.dto.FieldStatus;
import org.example.greenshadowsystem.dto.impl.FieldDTO;
import org.example.greenshadowsystem.entity.impl.FieldEntity;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.FieldNotFoundException;
import org.example.greenshadowsystem.service.FieldService;
import org.example.greenshadowsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceImpl implements FieldService {
    @Autowired
    private FieldDao fieldDao;
    @Autowired
    private Mapping fieldMapping;
    @Override
    public void saveField(FieldDTO fieldDTO) {
        FieldEntity savedField = fieldDao.save(fieldMapping.toFieldEntity(fieldDTO));
        if(savedField == null){
            throw new DataPersistException("Field not saved.");
        }
    }

    @Override
    public List<FieldDTO> getAllField() {
        List<FieldEntity> allFields = fieldDao.findAll();
        return fieldMapping.asFieldDTOList(allFields);
    }

    @Override
    public FieldStatus getField(String fieldId) {
        if (fieldDao.existsById(fieldId)) {
            FieldEntity selectedField = fieldDao.getReferenceById(fieldId);
            return fieldMapping.toFieldDTO(selectedField);
        } else {
            return new SelectedCustomErrorStatus(2, "Field not found.");
        }
    }

    @Override
    public void deleteField(String fieldId) {
        Optional<FieldEntity> foundField = fieldDao.findById(fieldId);
        if(!foundField.isPresent()){
            throw new FieldNotFoundException("Field not found.");
        }else{
            fieldDao.deleteById(fieldId);
        }
    }

    @Override
    public void updateField(String fieldId, FieldDTO fieldDTO) {
        Optional<FieldEntity> findField = fieldDao.findById(fieldId);
        if(!findField.isPresent()){
            throw new FieldNotFoundException("Field not found");
        }else {
            findField.get().setFieldName(fieldDTO.getFieldName());
            findField.get().setLocation(fieldDTO.getLocation());
            findField.get().setSize(fieldDTO.getSize());
            findField.get().setImg1(fieldDTO.getImg1());
            findField.get().setImg2(fieldDTO.getImg2());
        }
    }
}
