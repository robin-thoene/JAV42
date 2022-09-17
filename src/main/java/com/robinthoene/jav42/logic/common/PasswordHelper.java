package com.robinthoene.jav42.logic.common;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class PasswordHelper {


    /**
     * Hash a password.
     *
     * @param password The password to hash.
     * @return The hashed password.
     */
    public static String hashPassword(String password) {
        try {
            var messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            var digest = messageDigest.digest();
            var hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            return hash;
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
}
