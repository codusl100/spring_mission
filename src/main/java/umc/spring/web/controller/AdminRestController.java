package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.apiPayload.code.status.SuccessStatus;
import umc.spring.service.AdminService.AdminCommandService;
import umc.spring.web.dto.AdminRequestDTO;

import javax.validation.Valid;

import static umc.spring.apiPayload.code.status.SuccessStatus._OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminRestController {

    private final AdminCommandService adminCommandService;

    @PostMapping("/place")
    public ApiResponse<SuccessStatus> join(@RequestBody @Valid AdminRequestDTO.plusPlaceDTO request){
        adminCommandService.plusPlace(request);
        return ApiResponse.onSuccess(_OK);
    }
}
