package com.rating_backend.hotel.repository;

import com.rating_backend.hotel.model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotels, Integer> {
}
