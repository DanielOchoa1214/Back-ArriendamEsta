package com.eci.ariendamesta.exceptions;

public class AuthException extends AppExceptions {

    public static String USER_DOESNT_EXIST = "User does not exist";
    public static String INVALID_CREDENTIALS = "Username or password are incorrect";
    public AuthException(String message) {
        super(message);
    }
}
