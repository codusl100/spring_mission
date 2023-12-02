package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.PlaceRequestDTO;
import umc.spring.web.dto.PlaceResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {

    public static Review toAddReview(PlaceRequestDTO.writeReviewDTO request){
        return Review.builder()
                .reviewText(request.getReviewText())
                .ratePoint(request.getRatePoint())
                .photoList(new ArrayList<>())
                .build();
    }

    public static PlaceResponseDTO.writeReviewDTO toAddReviewDTO(Review review){
        return PlaceResponseDTO.writeReviewDTO.builder()
                .missionId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
