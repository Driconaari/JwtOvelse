package com.jwtovelse.keyGenerator;

import java.security.SecureRandom;
import java.util.Base64;

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
