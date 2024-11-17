package org.example.greenshadowsystem.service.impl;

import org.example.greenshadowsystem.customStatusCodes.SelectedCustomErrorStatus;
import org.example.greenshadowsystem.dao.StaffDao;
import org.example.greenshadowsystem.dto.StaffStatus;
import org.example.greenshadowsystem.dto.impl.StaffDTO;
import org.example.greenshadowsystem.entity.impl.StaffEntity;
import org.example.greenshadowsystem.exception.DataPersistException;
import org.example.greenshadowsystem.exception.StaffNotFoundException;
import org.example.greenshadowsystem.service.StaffService;
import org.example.greenshadowsystem.util.AppUtil;
import org.example.greenshadowsystem.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private Mapping staffMapping;
    /*private static List<NoteDTO> noteDTOList = new ArrayList<>();

    NoteServiceImpl(){
        noteDTOList.add(new NoteDTO())
    }*/
    @Override
    public void saveStaff(StaffDTO staffDTO){
        staffDTO.setStaffId(AppUtil.generateStaffId());
        StaffEntity savedStaff = staffDao.save(staffMapping.toStaffEntity(staffDTO));
        if(savedStaff == null){
            throw new DataPersistException("Staff member not saved.");
        }
    }

    @Override
    public List<StaffDTO> getAllStaff() {
        return staffMapping.asStaffDTOList(staffDao.findAll());
    }

    @Override
    public StaffStatus getStaff(String staffId) {
        if(staffDao.existsById(staffId)){
            var selectedStaff = staffDao.getReferenceById(staffId);
            return staffMapping.toStaffDTO(selectedStaff);
        }
        return new SelectedCustomErrorStatus(2, "Selected Staff member not found.");
    }

    @Override
    public void deleteStaff(String staffId) {
        Optional<StaffEntity> foundStaff = staffDao.findById(staffId);
        if(!foundStaff.isPresent()){
            throw new StaffNotFoundException("Staff member not found.");
        }else{
            staffDao.deleteById(staffId);
        }
    }

    @Override
    public void updateStaff(String staffId, StaffDTO staffDTO) {
        Optional<StaffEntity> findStaff = staffDao.findById(staffId);
        if(!findStaff.isPresent()){
            throw new StaffNotFoundException("Staff member not found");
        }else {
            findStaff.get().setName(staffDTO.getName());
            findStaff.get().setRole(staffDTO.getRole());
            findStaff.get().setDesignation(staffDTO.getDesignation());
            findStaff.get().setGender(staffDTO.getGender());
            findStaff.get().setJoinedDate(staffDTO.getJoinedDate());
            findStaff.get().setEmail(staffDTO.getEmail());
            findStaff.get().setAddress(staffDTO.getAddress());
            findStaff.get().setDob(staffDTO.getDob());
            findStaff.get().setContactNum(staffDTO.getContactNum());
        }
    }
}
