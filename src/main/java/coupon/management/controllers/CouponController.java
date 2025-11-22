package coupon.management.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupon.management.entity.Coupon;
import coupon.management.services.CouponService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @PostMapping("/add")
    public ResponseEntity<?> addCouResponseEntity(@RequestBody Coupon coupon) {
        Coupon saved = couponService.saveCoupon(coupon);
        if(saved != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing Error has Occured During Adding Coupon in DB !!!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon) {
        Coupon saved = couponService.updateCoupon(coupon);
        if(saved != null) {
            return ResponseEntity.status(HttpStatus.OK).body(saved);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing Error has Occured During Adding Coupon in DB !!!");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCoupons() {
        List<Coupon> saved = couponService.getAllCoupons();
        if(saved == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DB is Empty !!!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(saved);
    }

    @GetMapping("/getBestCoupon")
    public ResponseEntity<?> getBestCoupon() {
        return null;
    }
    
}
