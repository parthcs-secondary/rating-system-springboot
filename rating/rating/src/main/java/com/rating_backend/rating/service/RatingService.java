package com.rating_backend.rating.service;

import com.rating_backend.rating.model.Ratings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

    //create
    Ratings createRating(Ratings rating);

    // get all ratings
    List<Ratings> getAllRatings();

    //get rating by userId
    List<Ratings> getRatingsByUserId(int userId);

    //    get rating by hotel
    List<Ratings> getRatingsByHotelId(int hotelId);


    List<Ratings> createBulkRating(List<Ratings> rating);
}
