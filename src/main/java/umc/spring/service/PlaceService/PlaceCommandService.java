package umc.spring.service.PlaceService;


import umc.spring.domain.Review;
import umc.spring.domain.mapping.UserMission;
import umc.spring.web.dto.PlaceRequestDTO;

public interface PlaceCommandService {
    public boolean checkPlaces(Long placeId);

    public Review writeReview(PlaceRequestDTO.writeReviewDTO request);

    public boolean checkMissionStatus(UserMission mission);
}
