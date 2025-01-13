package com.club.magazine_club_program.Service;

import com.club.magazine_club_program.DTO.ManagementDTO;
import com.club.magazine_club_program.Mapper.ManagementMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ManagementService {
    private final ManagementMapper managementMapper;

    public ManagementService(ManagementMapper managementMapper) {
        this.managementMapper = managementMapper;
    }

    // 모든 멤버 상태 조회
    public List<ManagementDTO> getAllMemberStat() {
        return managementMapper.findAll();
    }

    // 출석 상태 업데이트
    public boolean updateAttendance(ManagementDTO managementDTO) {
        managementDTO.setAttendance(managementDTO.isAttendance());
        int Updated = managementMapper.updateAttendance(managementDTO.getId(), managementDTO.isAttendance());
        ResponseEntity.ok();
        return Updated > 0;
    }

    // 과제 상태 업데이트
    public boolean updateTask(ManagementDTO managementDTO) {
        managementDTO.setTask(managementDTO.isTask());
        int Updated = managementMapper.updateTask(managementDTO.getId(), managementDTO.isTask());
        ResponseEntity.ok();
        return Updated > 0;
    }
}
