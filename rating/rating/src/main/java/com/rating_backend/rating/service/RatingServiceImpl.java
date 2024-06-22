package com.rating_backend.rating.service;

import com.rating_backend.rating.Repository.RatingRepository;
import com.rating_backend.rating.exception.ResponseNotFoundException;
import com.rating_backend.rating.model.Ratings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements  RatingService{

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Ratings createRating(Ratings rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUserId(int userId) throws ResponseNotFoundException{
            return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getRatingsByHotelId(int hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Ratings> createBulkRating(List<Ratings> rating) {
        return ratingRepository.saveAll(rating);
    }
}
