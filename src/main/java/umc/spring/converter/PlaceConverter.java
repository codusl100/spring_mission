package umc.spring.converter;

import umc.spring.domain.Place;
import umc.spring.domain.enums.PlaceStatus;
import umc.spring.web.dto.AdminRequestDTO;
import umc.spring.web.dto.AdminResponseDTO;

import java.time.LocalDateTime;

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
}
