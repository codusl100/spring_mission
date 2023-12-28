package umc.spring.service.PlaceService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.PlaceRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PlaceQueryServiceImpl implements PlaceQueryService{
    private final PlaceRepository placeRepository;

    @Override
    @Transactional
    public boolean checkPlaces(Long placeId){
        return placeRepository.findById(placeId).isPresent();
    }
}
