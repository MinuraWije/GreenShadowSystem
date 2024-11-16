package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.FieldStatus;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO implements FieldStatus {
    private String fieldCode;
    private String fieldName;
    private Point location;
    private Double size;
    private String img1;
    private String img2;
    private List<CropDTO> crops;
    private List<FieldedStaffDTO> fieldedStaffs;
    private List<FieldEquipmentDTO> fieldEquipments;
    private List<FieldLogDTO> fieldLogs;
}
