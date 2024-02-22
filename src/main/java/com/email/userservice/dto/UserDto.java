package com.email.userservice.dto;

public record UserDto(

         Long id,
         String firstName,
         String lastName,
         String email,
         boolean isEnabled) {
}
