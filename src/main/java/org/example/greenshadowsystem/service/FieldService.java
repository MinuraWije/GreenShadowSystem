package org.example.greenshadowsystem.service;

import org.example.greenshadowsystem.dto.FieldStatus;
import org.example.greenshadowsystem.dto.impl.FieldDTO;

import java.util.List;

public interface FieldService {
    void saveField(FieldDTO fieldDTO);
    List<FieldDTO> getAllField();
    FieldStatus getField(String fieldDTO);
    void deleteField(String fieldId);
    void updateField(String fieldId,FieldDTO fieldDTO);
}
