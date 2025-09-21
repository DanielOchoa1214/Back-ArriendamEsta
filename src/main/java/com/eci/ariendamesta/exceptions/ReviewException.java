package com.eci.ariendamesta.exceptions;

public class ReviewException extends AppExceptions {

    public static String NOT_FOUND = "Review does not exist";
    public static String NOT_CREATED = "Review already exists";
    public static String NOT_UPDATED = "Review not updated";
    public static String NOT_DELETED = "Review not deleted";

    public ReviewException(String message) {
        super(message);
    }
}
