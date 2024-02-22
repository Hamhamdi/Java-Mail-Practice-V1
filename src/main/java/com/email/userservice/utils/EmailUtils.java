package com.email.userservice.utils;

public class EmailUtils {
    
    public static String getEmailMessage(String name, String host, String token){
        return "Hello"+name+",Your account is created, please click the link below  to verify your account \n\n"+ getVerificationUrl(host, token)+"\n\n Support Team";
    }

    private static String getVerificationUrl(String host, String token) {
        return host+ "/api/users?token="+ token;
    }
}
