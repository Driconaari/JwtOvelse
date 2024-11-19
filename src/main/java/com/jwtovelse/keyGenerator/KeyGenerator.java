package com.jwtovelse.keyGenerator;

import java.security.SecureRandom;
import java.util.Base64;

//READ ME
//This class is used to generate a secret key for the JwtUtil class
//The secret key is used to sign the JWT token
//The secret key should be kept secret and should not be shared with anyone
//The secret key should be stored in a secure location
//The secret key should be a random string of characters
//USE THE KEY IN THE ENVIRONMENT VARIABLE IN PROJECTION SETTINGS

public class KeyGenerator {

    public static String generateKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32]; // 256-bit key
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    public static void main(String[] args) {
        String secretKey = generateKey();
        System.out.println("Generated Secret Key: " + secretKey);
    }
}
