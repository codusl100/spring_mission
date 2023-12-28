package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Place;
import umc.spring.domain.Review;
import umc.spring.domain.enums.PlaceStatus;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.AdminRequestDTO;
import umc.spring.web.dto.AdminResponseDTO;
import umc.spring.web.dto.PlaceResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PlaceConverter {

    public static Place toAddPlace(AdminRequestDTO.plusPlaceDTO request){

        return Place.builder()
                .placeName(request.getPlaceName())
                .placeAddress(request.getPlaceAddress())
                .placeStatus(PlaceStatus.OPEN)
                .openTime(request.getOpenTime())
                .closeTime(request.getCloseTime())
                .build();

    }

    public static AdminResponseDTO.toAddPlaceDTO toAddPlaceDTO(Place place){
        return AdminResponseDTO.toAddPlaceDTO.builder()
                    .placeId(place.getId())
                    .createdAt(LocalDateTime.now())
                    .build();
    }

    public static PlaceResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return PlaceResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getRatePoint())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getReviewText())
                .build();
    }
    public static PlaceResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<PlaceResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(PlaceConverter::reviewPreViewDTO).collect(Collectors.toList());

        return PlaceResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static PlaceResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return PlaceResponseDTO.MissionPreViewDTO.builder()
                .missionCondition(mission.getMissionCondition())
                .missionPoint(mission.getMissionPoint())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static PlaceResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<PlaceResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(PlaceConverter::missionPreViewDTO).collect(Collectors.toList());

        return PlaceResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static PlaceResponseDTO.MissionPreViewDTO userMissionPreViewDTO(UserMission userMission){
        Mission mission = userMission.getMission();
        return PlaceResponseDTO.MissionPreViewDTO.builder()
                .missionCondition(mission.getMissionCondition())
                .missionPoint(mission.getMissionPoint())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static PlaceResponseDTO.MissionPreViewListDTO myMissionPreViewListDTO(Page<UserMission> missionList){
        List<PlaceResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(PlaceConverter::userMissionPreViewDTO).collect(Collectors.toList());

        return PlaceResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
