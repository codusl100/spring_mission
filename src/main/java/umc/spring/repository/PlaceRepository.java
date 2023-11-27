package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
