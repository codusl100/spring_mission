package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Place;
import umc.spring.domain.Review;
import umc.spring.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByPlace(Place store, PageRequest pageRequest);

    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
