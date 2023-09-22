package com.eci.ariendamesta.exceptions;

public class ReviewException extends AppExceptions {

    public static String NOT_FOUND = "Review does not exist";
    public static String NOT_CREATED = "Review already exists";

    public ReviewException(String message) {
        super(message);
    }
}
