package com.rating_backend.hotel.service;

import com.rating_backend.hotel.model.Hotels;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {

    //get all hotels
    public List<Hotels> getAllHotels();

    //get hotel by ID
    public Hotels getHotelById(int id);

    //create new hotel
    public Hotels createHotel(Hotels hotel);

    //delete hotel
    public void deleteHotel(int id);

    //update a hotel
    public Hotels updateHotel(Hotels hotel);

    List<Hotels> createBulkUsers(List<Hotels> users);
}
