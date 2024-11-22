package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dao.LogDao;
import org.example.greenshadowsystem.dto.LogStatus;
import org.example.greenshadowsystem.dto.impl.LogDTO;
import org.example.greenshadowsystem.entity.impl.LogEntity;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.LogNotFoundException;
import org.example.greenshadowsystem.service.LogService;
import org.example.greenshadowsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    @Autowired
    private Mapping logMapping;
    @Override
    public void saveLog(LogDTO logDTO) {
        LogEntity savedLog = logDao.save(logMapping.toLogEntity(logDTO));
        if(savedLog == null){
            throw new DataPersistException("Log not saved.");
        }
    }

    @Override
    public List<LogDTO> getAllLog() {
        List<LogEntity> allLogs = logDao.findAll();
        return logMapping.asLogDTOList(allLogs);
    }

    @Override
    public LogStatus getLog(String logId) {
        if (logDao.existsById(logId)) {
            LogEntity selectedLog = logDao.getReferenceById(logId);
            return logMapping.toLogDTO(selectedLog);
        } else {
            return new SelectedCustomErrorStatus(2, "Log not found.");
        }
    }

    @Override
    public void deleteLog(String logId) {
        Optional<LogEntity> foundLog = logDao.findById(logId);
        if(!foundLog.isPresent()){
            throw new LogNotFoundException("Log not found.");
        }else{
            logDao.deleteById(logId);
        }
    }

    @Override
    public void updateLog(String logId, LogDTO logDTO) {
        Optional<LogEntity> findLog = logDao.findById(logId);
        if(!findLog.isPresent()){
            throw new LogNotFoundException("Log not found");
        }else {
            findLog.get().setLogDetails(logDTO.getLogDetails());
            findLog.get().setLogDate(logDTO.getLogDate());
            findLog.get().setObservedImg(logDTO.getObservedImg());
        }
    }
}
