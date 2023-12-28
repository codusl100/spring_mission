package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static Review toAddReview(MissionRequestDTO.writeReviewDTO request){
        return Review.builder()
                .reviewText(request.getReviewText())
                .ratePoint(request.getRatePoint())
                .photoList(new ArrayList<>())
                .build();
    }

    public static MissionResponseDTO.writeReviewDTO toAddReviewDTO(Review review){
        return MissionResponseDTO.writeReviewDTO.builder()
                .missionId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
