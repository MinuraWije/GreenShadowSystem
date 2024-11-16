package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.FieldLogStatus;
import org.example.greenshadowsystem.entity.impl.FieldLogID;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldLogDTO implements FieldLogStatus {
    private FieldLogID fieldLogID;
    private Date date;
    private FieldDTO field;
    private LogDTO log;
}
