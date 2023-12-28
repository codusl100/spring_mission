package umc.spring.web.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import umc.spring.validation.annotation.ExistPlaces;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public class AdminRequestDTO {

    @Getter
    public static class plusPlaceDTO{
        @NotBlank
        String placeName;
        @NotBlank
        String placeAddress;
        @DateTimeFormat(pattern = "kk:mm:ss")
        LocalTime openTime;
        @DateTimeFormat(pattern = "kk:mm:ss")
        LocalTime closeTime;
        Long foodType;
    }

    @Getter
    public static class plusMissionDTO{
        @NotNull
        Integer missionPoint;
        @NotBlank
        String missionCondition;
        @NotNull
        LocalDate missionDate;
        @ExistPlaces
        Long placeId;
    }
}
