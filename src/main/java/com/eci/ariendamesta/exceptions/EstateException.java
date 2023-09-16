package com.eci.ariendamesta.exceptions;


public class EstateException extends Exception {

    public static String NOT_FOUND = "Estate does not found";

    public EstateException(String message) {
        super(message);
    }
}
