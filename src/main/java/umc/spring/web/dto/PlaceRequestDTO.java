package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.CheckRatePoint;
import umc.spring.validation.annotation.ExistPlaces;
import umc.spring.validation.annotation.LimitReviewPhoto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class PlaceRequestDTO {

    @Getter
    public static class writeReviewDTO{
        @CheckRatePoint
        Float ratePoint;
        @NotNull
        String reviewText;
        @LimitReviewPhoto
        List<String> photoUrl;
        @ExistPlaces
        Long placeId;
    }

}
