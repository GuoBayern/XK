package com.XK.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.MessageDigest;
import java.util.Stack;

public class PasswordSaltDynamic {

    private static final char[] array = { 'q', 's', 'e', 'r', 't', 'y', 'g', 'i', 'o', 'p', 'a', 'w', 'd', 'f', 'u',
            'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '3', '5', '2', '7', '8', '6', '4', '0', '9', '1',
            'Q', 'B', 'E', 'R', 'T', 'Y', 'O', 'I', 'U', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X',
            'C', 'V', 'W', 'N', 'M', '-', '+' };

    //加密
    private static String encode(long number){
        long rest = number;
        //创建栈
        Stack<Character> stack = new Stack<Character>();
        StringBuilder stringBuilder = new StringBuilder(0);
        while (rest >= 1){
            //进栈
            stack.add(array[Long.valueOf(rest % 64).intValue()]);
            rest = rest / 64;
        }
        for (; !stack.isEmpty();){
            //出栈
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    //解密
    public static long decode(String string){
        //倍数
        int multiple = 1;
        long result = 0;
        Character character;
        for (int i = 0; i < string.length(); i++){
            character = string.charAt(string.length() - i - 1);
            result = result + decodeChar(character) * multiple;
            multiple = multiple * 64;
        }
        return result;
    }

    private static int decodeChar(Character character){
        for (int i = 0; i < array.length; i++){
            if (character == array[i]){
                return i;
            }
        }
        return -1;
    }

    //哈希盐
    private static String getMD5(String string){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string.getBytes());
            byte[] b = messageDigest.digest();
            int i;
            StringBuilder stringBuilder = new StringBuilder("");
            for (byte value : b) {
                i = value;
                if (i < 0) {
                    i = i + 256;
                }
                if (i < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i));
            }
            string = stringBuilder.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return string;
    }

    //利用用户名进行哈希加密
    public static String enHash(String string, String password){
        String salt = encode(Long.parseLong(string));
        String hashSalt = getMD5(salt);
        return new SimpleHash("SHA-1", password, hashSalt).toString();
    }

}
