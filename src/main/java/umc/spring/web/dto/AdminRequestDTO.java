package umc.spring.web.dto;

import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import umc.spring.validation.annotation.ExistCategories;

import java.time.LocalTime;

public class AdminRequestDTO {

    @Getter
    public static class plusPlaceDTO{
        String placeName;
        String placeAddress;
        @DateTimeFormat(pattern = "kk:mm:ss")
        LocalTime openTime;
        @DateTimeFormat(pattern = "kk:mm:ss")
        LocalTime closeTime;
        Long foodType;
    }
}
