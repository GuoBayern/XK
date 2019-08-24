package com.XK.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordSalt {

    private static final  String SALT_STRING = "be5e0323a9195ade5f56695edh83f489h203nfi74d8740406838dc84f152014b39a2414fb3530a40bc028a9e87642bd03cf5c36a1f70801e";
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private Object salt;
    private String algorithm;

    private PasswordSalt(Object salt, String algorithm){
        this.salt = salt;
        this.algorithm = algorithm;
    }

    private String encode(String rawPass){
        String result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            //加密后的字符串
            result = byteArrayToHexString(messageDigest.digest(mergePasswordAndSalt(rawPass).getBytes(StandardCharsets.UTF_8)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private boolean isPasswordValid(String encPass, String rawPass){
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);
        return pass1.equals(pass2);
    }

    private String mergePasswordAndSalt(String password){
        if (password == null){
            password = "";
        }
        if ((salt == null) || "".equals(salt)){
            return password;
        }
        else {
            return password + "{" + salt.toString() + "}";
        }
    }

    //转换字节数组为16进制
    private static String byteArrayToHexString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(byteToHexString(aByte));
        }
        return stringBuilder.toString();
    }

    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0){
            n = n + 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String passSalt(String password){
        PasswordSalt passwordSalt = new PasswordSalt(SALT_STRING, "MD5");
        return passwordSalt.encode(password);
    }

}
