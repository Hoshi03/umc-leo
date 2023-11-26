package leo.umc.repository;

import leo.umc.domain.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
