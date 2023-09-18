package com.eci.ariendamesta.exceptions;


public class EstateException extends AppExceptions {

    public static String NOT_FOUND = "Estate does not exist";
    public static String NOT_CREATED = "Estate already exists";
    public static String NOT_UPDATED = "Estate can not be updated";
    public static String NOT_DELETED = "Estate can not be deleted";
    public EstateException(String message) {
        super(message);
    }
}
