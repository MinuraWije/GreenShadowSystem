package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.LogStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogDTO implements LogStatus {
    private String logCode;
    private String logDetails;
    private String logDate;
    private String observedImg;
    private List<CropLogDTO> cropLogs;
    private List<FieldLogDTO> fieldLogs;
    private List<StaffLogDTO> staffLogs;
}
