package umc.spring.service.PlaceService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Place;
import umc.spring.domain.Review;

import java.util.Optional;

public interface PlaceQueryService {

    Optional<Place> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Review> getMyReviewList(Integer page);

    Page<Mission> getMissionList(Long StoreId, Integer page);
}
