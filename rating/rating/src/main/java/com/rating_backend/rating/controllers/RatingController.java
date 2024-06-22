package com.rating_backend.rating.controllers;

import com.rating_backend.rating.model.Ratings;
import com.rating_backend.rating.service.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingController {

    @Autowired
    RatingServiceImpl ratingService;

    @PostMapping("create")
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @PostMapping("create/bulk")
    public ResponseEntity<List<Ratings>> createRating(@RequestBody List<Ratings> rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createBulkRating(rating));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Ratings>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingbyHotelId(@PathVariable int hotelId) {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>> getRatingbyUserId(@PathVariable int userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

}

