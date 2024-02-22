package com.email.userservice.service;


import com.email.userservice.models.User;

public interface userService {
User saveUser(User user);
Boolean verifyToken(String token);

}
