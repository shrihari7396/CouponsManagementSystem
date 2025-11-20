package coupon.management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import coupon.management.entity.Coupon;
import coupon.management.repository.CouponsRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponService {
    
    private final CouponsRepository couponsRepository;

    public Coupon saveCoupon(Coupon coupon) {
        return couponsRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons() {
        return couponsRepository.findAll();
    } 
}
