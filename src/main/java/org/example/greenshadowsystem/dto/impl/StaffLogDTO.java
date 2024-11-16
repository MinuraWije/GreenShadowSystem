package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.StaffLogStatus;
import org.example.greenshadowsystem.entity.impl.StaffLogID;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffLogDTO implements StaffLogStatus {
    private StaffLogID staffLogID;
    private Date date;
    private StaffDTO staff;
    private LogDTO logCode;
}
