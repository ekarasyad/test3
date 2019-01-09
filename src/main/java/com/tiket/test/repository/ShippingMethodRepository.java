package com.tiket.test.repository;


import com.tiket.test.model.ShippingMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends JpaRepository<ShippingMethods, Long> {
}
