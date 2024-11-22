package org.example.greenshadowsystem.service;

import org.example.greenshadowsystem.dto.LogStatus;
import org.example.greenshadowsystem.dto.impl.LogDTO;

import java.util.List;

public interface LogService {
    void saveLog(LogDTO logDTO);
    List<LogDTO> getAllLog();
    LogStatus getLog(String logDTO);
    void deleteLog(String logId);
    void updateLog(String logId,LogDTO logDTO);
}
