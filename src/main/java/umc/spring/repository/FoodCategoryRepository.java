package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodType;

public interface FoodCategoryRepository extends JpaRepository<FoodType, Long> {
}
