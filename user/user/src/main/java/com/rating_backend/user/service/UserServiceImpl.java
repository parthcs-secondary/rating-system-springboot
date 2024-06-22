package com.rating_backend.user.service;

import com.rating_backend.user.exception.ResourceNotFoundException;
import com.rating_backend.user.model.Hotel;
import com.rating_backend.user.model.Rating;
import com.rating_backend.user.model.Users;
import com.rating_backend.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

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
        Rating[] ratingArray = restTemplate.getForObject("http://RATING/ratings/users/"+user.getId(), Rating[].class);
        logger.info("{} ", ratingArray);

        List<Rating> ratingList = Arrays.stream(ratingArray).map(rating -> {

            ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://HOTEL/hotels/get/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
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
