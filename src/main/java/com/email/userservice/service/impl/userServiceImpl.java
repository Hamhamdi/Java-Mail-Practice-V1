package com.email.userservice.service.impl;

import com.email.userservice.models.Confirmation;
import com.email.userservice.models.User;
import com.email.userservice.repository.userRepo;
import com.email.userservice.repository.confirmationRepo;
import com.email.userservice.service.emailService;
import com.email.userservice.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final userRepo userRepo;
    private final confirmationRepo confirmationRepo;
    private final emailService emailservice;

    @Override
    public User saveUser(User user) {
        if(userRepo.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already exists");
        }
        user.setEnabled(false);
        userRepo.save(user);
        Confirmation conf = new Confirmation(user);
        confirmationRepo.save(conf);
        //To do send email to user
       // emailservice.sendSimpleMailMessage(user.getFirstName(), user.getEmail(), conf.getToken());
        emailservice.sendMimeMessageWithAttachments(user.getFirstName(), user.getEmail(), conf.getToken());

        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepo.findByToken(token);
        User user = userRepo.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        user.setEnabled(true);
        userRepo.save(user);

        return Boolean.TRUE;
    }
}
