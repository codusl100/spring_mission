package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.PlaceConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.service.PlaceService.PlaceCommandService;
import umc.spring.service.PlaceService.PlaceQueryService;
import umc.spring.validation.annotation.ExistPlaces;
import umc.spring.web.dto.PlaceRequestDTO;
import umc.spring.web.dto.PlaceResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceRestController {

    private final PlaceCommandService placeCommandService;
    private final PlaceQueryService placeQueryService;

    @PostMapping("/review")
    public ApiResponse<PlaceResponseDTO.writeReviewDTO> writeReview(@RequestBody @Valid PlaceRequestDTO.writeReviewDTO request){
        Review review = placeCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewDTO(review));
    }

    @GetMapping("/{placeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<PlaceResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistPlaces @PathVariable(name = "placeId") Long placeId, @RequestParam(name = "page") Integer page){
        Page<Review> placePage = placeQueryService.getReviewList(placeId, page);
        return ApiResponse.onSuccess(PlaceConverter.reviewPreViewListDTO(placePage));
    }

    @GetMapping("/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",description = "내가 작성한 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요" +
            "로그인 API가 존재하지 않아 jwt token으로 유저 구별하는 대신 특정 유저 id로 조회!")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<PlaceResponseDTO.ReviewPreViewListDTO> getMyReviewList(@RequestParam(name = "page") Integer page){
        Page<Review> placePage = placeQueryService.getMyReviewList(page-1);
        return ApiResponse.onSuccess(PlaceConverter.reviewPreViewListDTO(placePage));
    }

    @GetMapping("/{placeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "placeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<PlaceResponseDTO.MissionPreViewListDTO> getMissionList(@ExistPlaces @PathVariable(name = "placeId") Long placeId, @RequestParam(name = "page") Integer page){
        Page<Mission> placePage = placeQueryService.getMissionList(placeId, page-1);
        return ApiResponse.onSuccess(PlaceConverter.missionPreViewListDTO(placePage));
    }

}
