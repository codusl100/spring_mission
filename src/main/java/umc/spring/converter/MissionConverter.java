package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.AdminRequestDTO;
import umc.spring.web.dto.AdminResponseDTO;
import umc.spring.web.dto.MissionResponseDTO;

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

    public static UserMission toAddUserMission(Mission mission){
        return UserMission.builder()
                .mission(mission)
                .missionStatus(MissionStatus.ONGOING)
                .build();
    }

    public static MissionResponseDTO.challengeMissionDTO challengeMissionDTO (UserMission mission){
        return MissionResponseDTO.challengeMissionDTO.builder()
                .userMissionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
