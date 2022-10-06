package texnopark.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import texnopark.appgreenshop.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
