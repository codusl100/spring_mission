package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.PlaceConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Place;
import umc.spring.service.AdminService.AdminCommandService;
import umc.spring.web.dto.AdminRequestDTO;
import umc.spring.web.dto.AdminResponseDTO;

import javax.validation.Valid;

import static umc.spring.apiPayload.code.status.SuccessStatus._OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {

    private final AdminCommandService adminCommandService;

    @PostMapping("/place")
    public ApiResponse<AdminResponseDTO.toAddPlaceDTO> addPlace(@RequestBody @Valid AdminRequestDTO.plusPlaceDTO request){
        Place place = adminCommandService.plusPlace(request);
        return ApiResponse.onSuccess(PlaceConverter.toAddPlaceDTO(place));
    }

    @PostMapping("/mission")
    public ApiResponse<AdminResponseDTO.toAddMissionDTO> addMission(@RequestBody @Valid AdminRequestDTO.plusMissionDTO request){
        Mission mission = adminCommandService.plusMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionDTO(mission));
    }
}
