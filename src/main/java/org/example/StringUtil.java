package org.example;

import java.security.MessageDigest;

public class StringUtil {
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));

            StringBuilder hex = new StringBuilder();

            for(byte b : hashBytes) {
                String hexChar = Integer.toHexString(0xff & b);
                if (hexChar.length() == 1) hex.append('0');
                hex.append(hexChar);
//                System.out.println(hexChar);
            }

//            System.out.println(hex.toString());
            return hex.toString();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
