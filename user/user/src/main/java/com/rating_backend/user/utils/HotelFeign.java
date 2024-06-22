package com.rating_backend.user.utils;

import com.rating_backend.user.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL")
public interface HotelFeign {

    @GetMapping("/hotels/get/{hotelId}")
    ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId);


}
