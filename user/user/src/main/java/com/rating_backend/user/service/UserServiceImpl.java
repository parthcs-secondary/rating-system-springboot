package com.rating_backend.user.service;

import com.rating_backend.user.exception.ResourceNotFoundException;
import com.rating_backend.user.model.Hotel;
import com.rating_backend.user.model.Rating;
import com.rating_backend.user.model.Users;
import com.rating_backend.user.repository.UserRepository;
import com.rating_backend.user.utils.HotelFeign;
import com.rating_backend.user.utils.RatingFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RatingFeign ratingFeign;

    @Autowired
    HotelFeign hotelFeign;

    @Override
    public List<Users> createBulkUsers(List<Users> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(int id) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        ResponseEntity<List<Rating>> ratingList = ratingFeign.getRatingsById(user.getId());
        List<Rating> ratingList1 = ratingList.getBody().stream().map(rating -> {
            ResponseEntity<Hotel> hotel = hotelFeign.getHotelById(rating.getHotelId());
            rating.setHotel(hotel.getBody());
            return rating;
        }).toList();
        user.setRatings(ratingList1);
        return user;
    }


    @Override
    public void deleteUser(int id) {

    }

    @Override
    public Users updateUser(Users user) {
        return null;
    }

}
