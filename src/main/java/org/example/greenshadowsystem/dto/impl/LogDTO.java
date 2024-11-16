package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.LogStatus;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogDTO implements LogStatus {
    private String logCode;
    private String logDetails;
    private Date logDate;
    private String observedImg;
    private List<CropDTO> cropLogs;
    private List<FieldDTO> fieldLogs;
    private List<StaffDTO> staffLogs;
}
