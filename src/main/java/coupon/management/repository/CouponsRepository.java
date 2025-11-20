package coupon.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coupon.management.entity.Coupon;

@Repository
public interface CouponsRepository extends JpaRepository<Coupon, Long> {
    
}
