package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.CropLogStatus;
import org.example.greenshadowsystem.entity.impl.CropLogID;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropLogDTO implements CropLogStatus {
    private CropLogID cropLogID;
    private Date date;
    private LogDTO log;
    private CropDTO crop;
}
