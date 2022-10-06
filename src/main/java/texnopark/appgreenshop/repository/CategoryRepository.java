package texnopark.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import texnopark.appgreenshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
