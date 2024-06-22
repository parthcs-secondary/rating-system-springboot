package com.rating_backend.rating.Repository;

import com.rating_backend.rating.model.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Ratings, String> {

    List<Ratings> findByUserId(int userId);

    List<Ratings> findByHotelId(int hotelId);
}
