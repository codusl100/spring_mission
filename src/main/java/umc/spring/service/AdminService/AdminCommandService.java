package umc.spring.service.AdminService;

import umc.spring.domain.Mission;
import umc.spring.domain.Place;
import umc.spring.web.dto.AdminRequestDTO;

public interface AdminCommandService {
    public Place plusPlace(AdminRequestDTO.plusPlaceDTO request);

    public Mission plusMission(AdminRequestDTO.plusMissionDTO request);
}
