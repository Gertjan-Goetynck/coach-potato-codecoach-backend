package com.switchfully.codecoach.infrastructure.utils;

import java.util.UUID;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String EMAIL_FORMAT = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isEmptyString(Object object) {
        return object.toString().isEmpty();
    }

    public static boolean isBlankString(Object object) {
        return object.toString().isBlank();
    }

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_FORMAT);
    }

    public static void throwExceptionIfEmailNullEmptyBlankOrInvalid(String email, String emailname) {
        throwExceptionIfNullOrEmptyOrBlank(email, emailname);
        if(!isValidEmail(email)) throw new IllegalArgumentException(email + " is an invalid email format.");
    }

    public static void throwExceptionIfNullOrEmptyOrBlank(Object object, String objectName) {
        if (isNull(object))
            throw new IllegalArgumentException(objectName + " cannot be null.");
        else if (isBlankString(object))
            throw new IllegalArgumentException(objectName + " cannot be blank.");
        else if (isEmptyString(object))
            throw new IllegalArgumentException(objectName + " cannot be empty.");
    }

    public static UUID convertStringToUUID(String id) {
        if(!Pattern.matches("^[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$", id)) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        return UUID.fromString(id);
    }

    public static void throwExceptionIfObjectIsNull(Object object, String objectName){
        if (isNull(object)) throw new IllegalArgumentException(objectName + " cannot be null");
    }
}
