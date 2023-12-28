package umc.spring.service.AdminService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.PlaceConverter;
import umc.spring.domain.Place;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.PlaceRepository;
import umc.spring.web.dto.AdminRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AdminCommandServiceImpl implements AdminCommandService{

    private final PlaceRepository placeRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public void plusPlace(AdminRequestDTO.plusPlaceDTO request){
        Place newPlace = PlaceConverter.toAddPlace(request);
        newPlace.setFoodType(foodCategoryRepository.findById(request.getFoodType()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)));
        placeRepository.save(newPlace);
    }
}
