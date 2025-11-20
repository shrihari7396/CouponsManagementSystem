package coupon.management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import coupon.management.entity.Coupon;
import coupon.management.repository.CouponsRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Coupon updateCoupon(Coupon updated) {
        Long id = updated.getId();
        Coupon existing = couponsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found with ID: " + id));

        Coupon updatedCoupon = Coupon.builder()
                .id(existing.getId()) // IMPORTANT → ensures UPDATE, not INSERT
                .code(updated.getCode()) // unique field
                .description(updated.getDescription())
                .discountType(updated.getDiscountType())
                .discountValue(updated.getDiscountValue())
                .maxDiscountAmount(updated.getMaxDiscountAmount())
                .startDate(updated.getStartDate())
                .endDate(updated.getEndDate())
                .usageLimitPerUser(updated.getUsageLimitPerUser())

                // Eligibility fields
                .allowedUserTiers(updated.getAllowedUserTiers())
                .minLifetimeSpend(updated.getMinLifetimeSpend())
                .minOrdersPlaced(updated.getMinOrdersPlaced())
                .firstOrderOnly(updated.getFirstOrderOnly())
                .allowedCountries(updated.getAllowedCountries())
                .minCartValue(updated.getMinCartValue())
                .applicableCategories(updated.getApplicableCategories())
                .excludedCategories(updated.getExcludedCategories())
                .minItemsCount(updated.getMinItemsCount())

                .build();

        return couponsRepository.save(updatedCoupon);
    }

}
