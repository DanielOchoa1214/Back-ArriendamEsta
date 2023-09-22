package com.eci.ariendamesta.exceptions;

public class PetitionException extends AppExceptions{

    public static String NOT_FOUND = "Petition does not exist";
    public static String NOT_CREATED = "Petition already exists";

    public PetitionException(String message) {super(message);}
}
