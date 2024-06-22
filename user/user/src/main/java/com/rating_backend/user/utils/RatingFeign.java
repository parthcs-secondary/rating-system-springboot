package com.rating_backend.user.utils;


import com.rating_backend.user.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING")
public interface RatingFeign {

    @GetMapping("/ratings/users/{userId}")
    ResponseEntity<List<Rating>> getRatingsById(@PathVariable int userId);


}
