package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.AdminRequestDTO;
import umc.spring.web.dto.AdminResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toAddMission(AdminRequestDTO.plusMissionDTO request){
        return Mission.builder()
                .missionCondition(request.getMissionCondition())
                .missionDate(request.getMissionDate())
                .missionPoint(request.getMissionPoint())
                .build();
    }

    public static AdminResponseDTO.toAddMissionDTO toAddMissionDTO (Mission mission){
        return AdminResponseDTO.toAddMissionDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
