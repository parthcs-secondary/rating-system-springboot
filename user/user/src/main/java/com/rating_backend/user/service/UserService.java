package com.rating_backend.user.service;

import com.rating_backend.user.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //get all users
    public List<Users> getAllUsers();

    //get user by ID
    public Users getUserById(int id);

    //create new user
    public Users createUser(Users user);

    //delete user
    public void deleteUser(int id);

    //update a user
    public Users updateUser(Users user);

    List<Users> createBulkUsers(List<Users> users);
}
