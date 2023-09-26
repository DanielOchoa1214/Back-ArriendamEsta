package com.eci.ariendamesta.exceptions;


public class PropertyException extends AppExceptions {

    public static String NOT_FOUND = "Property does not exist";
    public static String NOT_CREATED = "Property already exists";
    public static String NOT_UPDATED = "Property can not be updated";
    public static String NOT_DELETED = "Property can not be deleted";
    public PropertyException(String message) {
        super(message);
    }
}
