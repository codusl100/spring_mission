package umc.spring.service.MissionService;

import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    public Review writeReview(MissionRequestDTO.writeReviewDTO request);
}
