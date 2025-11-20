package coupon.management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import coupon.management.entity.enums.DiscountType;
import coupon.management.entity.enums.UserTiers;

@Entity
@Table(name = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unique coupon code
    @Column(nullable = false, unique = true)
    private String code;

    // human readable description
    @Column(nullable = false)
    private String description;

    // FLAT or PERCENT
    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private DiscountType discountType;

    // discount amount or percentage value
    @Column(nullable = false)
    private BigDecimal discountValue;

    // only for percent; optional
    private BigDecimal maxDiscountAmount;

    // coupon validity
    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    // optional limit per user
    private Integer usageLimitPerUser;

    // --------------------------
    //  Eligibility fields
    // --------------------------

    // user-based eligibility
    private String allowedUserTiers;       // stored as CSV list
    private BigDecimal minLifetimeSpend;
    private Integer minOrdersPlaced;
    private Boolean firstOrderOnly;
    @Enumerated(value = EnumType.ORDINAL)
    private UserTiers allowedCountries; 

    // cart-based eligibility
    private BigDecimal minCartValue;
    private String applicableCategories;   // CSV list
    private String excludedCategories;     // CSV list
    private Integer minItemsCount;

}

