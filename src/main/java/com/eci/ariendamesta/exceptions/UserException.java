package com.eci.ariendamesta.exceptions;


public class UserException extends Exception {

    public static String NOT_FOUND = "User does not exist";
    public static String NOT_CREATED = "User already exists";
    public static String NOT_UPDATE = "User can not be updated";
    public static String NOT_DELETE = "User can not be deleted";
    public UserException(String message) {
        super(message);
    }
}
