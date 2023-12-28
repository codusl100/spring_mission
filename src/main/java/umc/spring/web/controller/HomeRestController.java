package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.mapping.UserMission;
import umc.spring.service.HomeCommandService.HomeCommandService;
import umc.spring.web.dto.PlaceResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeRestController {

    private final HomeCommandService homeCommandService;

    @PostMapping("/missionList/{missionId}")
    public ApiResponse<PlaceResponseDTO.challengeMissionDTO> challengeMission(@PathVariable Long missionId){
        UserMission userMission = homeCommandService.challengeMission(missionId);
        return ApiResponse.onSuccess(MissionConverter.challengeMissionDTO(userMission));
    }
}
