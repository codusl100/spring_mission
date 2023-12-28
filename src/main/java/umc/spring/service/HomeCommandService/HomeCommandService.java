package umc.spring.service.HomeCommandService;

import umc.spring.domain.mapping.UserMission;

public interface HomeCommandService {
    public UserMission challengeMission(Long missionId);
}
