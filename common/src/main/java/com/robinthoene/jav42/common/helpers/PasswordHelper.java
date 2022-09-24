package com.robinthoene.jav42.common.helpers;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.GermanCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.MethodInvocationException;

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

    /**
     * Creates a random password.
     *
     * @return The generated password.
     */
    public static String createRandomPassword() {
        // Initialize a password generator.
        var passwordGenerator = new PasswordGenerator();
        // Define the rule for lower case characters.
        var lowerCaseCharacters = GermanCharacterData.LowerCase;
        var lowerCaseRule = new CharacterRule(lowerCaseCharacters);
        lowerCaseRule.setNumberOfCharacters(3);
        // Define the rule for upper case characters.
        var upperCaseCharacters = GermanCharacterData.UpperCase;
        var upperCaseRule = new CharacterRule(upperCaseCharacters);
        upperCaseRule.setNumberOfCharacters(3);
        // Define the rule for digits.
        var digitCharacters = EnglishCharacterData.Digit;
        var digitRule = new CharacterRule(digitCharacters);
        digitRule.setNumberOfCharacters(3);
        // Define rule for special characters.
        var specialChars = new CharacterData() {
            public String getErrorCode() {
                return MethodInvocationException.ERROR_CODE;
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(3);
        // Generate the password using the defined rules.
        var password = passwordGenerator.generatePassword(16, lowerCaseRule, upperCaseRule, splCharRule, digitRule);
        return password;
    }
}
