package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.CropStatus;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDTO implements CropStatus {
    private String cropCode;
    private String cropName;
    private String cropScientificName;
    private String category;
    private String img;
    private String season;
    private String fieldCode;
    private List<LogDTO> cropLogs;
}
