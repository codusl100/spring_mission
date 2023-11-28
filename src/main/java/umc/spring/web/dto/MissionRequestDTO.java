package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.CheckRatePoint;
import umc.spring.validation.annotation.LimitReviewPhoto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class writeReviewDTO{
        @CheckRatePoint
        Double ratePoint;
        @NotNull
        String reviewText;
        @LimitReviewPhoto
        List<String> photoUrl;
        Long placeId;
    }
}
