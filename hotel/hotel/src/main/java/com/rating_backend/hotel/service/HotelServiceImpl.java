package com.rating_backend.hotel.service;

import com.rating_backend.hotel.exception.ResourceNotFoundException;
import com.rating_backend.hotel.model.Hotels;
import com.rating_backend.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;


    @Override
    public Hotels createHotel(Hotels hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotels> createBulkUsers(List<Hotels> users) {
        return hotelRepository.saveAll(users);
    }

    @Override
    public List<Hotels> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotels getHotelById(int id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @Override
    public void deleteHotel(int id) {

    }

    @Override
    public Hotels updateHotel(Hotels hotel) {
        return null;
    }


}
