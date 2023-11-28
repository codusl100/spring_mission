package umc.spring.service.AdminService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.PlaceConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Place;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.PlaceRepository;
import umc.spring.web.dto.AdminRequestDTO;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AdminCommandServiceImpl implements AdminCommandService{

    private final PlaceRepository placeRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Place plusPlace(AdminRequestDTO.plusPlaceDTO request){
        Place newPlace = PlaceConverter.toAddPlace(request);
        newPlace.setFoodType(foodCategoryRepository.findById(request.getFoodType()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)));
        return placeRepository.save(newPlace);
    }

    @Override
    @Transactional
    public Mission plusMission(AdminRequestDTO.plusMissionDTO request){
        Mission newMission = MissionConverter.toAddMission(request);
        newMission.setPlace(placeRepository.findById(request.getPlaceId()).orElseThrow(() -> new MissionHandler(ErrorStatus.PLACE_NOT_FOUND)));
        return missionRepository.save(newMission);
    }
}
