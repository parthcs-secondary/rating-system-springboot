package com.rating_backend.hotel.controller;

import com.rating_backend.hotel.model.Hotels;
import com.rating_backend.hotel.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping("create")
    public ResponseEntity<Hotels> createHotel(@RequestBody Hotels hotel){
        return ResponseEntity.ok(hotelService.createHotel(hotel));
    }

    @PostMapping("create/bulk")
    public ResponseEntity<List<Hotels>> createBulkUsers(@RequestBody List<Hotels> users){
        return ResponseEntity.ok(hotelService.createBulkUsers(users));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Hotels>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Hotels> getHotelById(@PathVariable int id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }



    //delete hotel

    //update a hotel


}
