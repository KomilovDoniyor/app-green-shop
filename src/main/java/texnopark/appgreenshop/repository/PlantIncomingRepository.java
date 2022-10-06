package texnopark.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import texnopark.appgreenshop.entity.PlantIncoming;

@Repository
public interface PlantIncomingRepository extends JpaRepository<PlantIncoming, Long> {
}
