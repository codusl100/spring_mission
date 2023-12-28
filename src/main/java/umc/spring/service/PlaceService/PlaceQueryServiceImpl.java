package umc.spring.service.PlaceService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.PlaceConverter;
import umc.spring.domain.Place;
import umc.spring.domain.Review;
import umc.spring.repository.PlaceRepository;
import umc.spring.repository.ReviewRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlaceQueryServiceImpl implements PlaceQueryService{

    private final PlaceRepository placeRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Place> findStore(Long id) {
        return placeRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Place store = placeRepository.findById(StoreId).get();

        Page<Review> placePage = reviewRepository.findAllByPlace(store, PageRequest.of(page, 10));
        return placePage;
    }
}
