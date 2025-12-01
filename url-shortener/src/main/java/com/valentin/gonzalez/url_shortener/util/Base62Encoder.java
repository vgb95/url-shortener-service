package com.valentin.gonzalez.url_shortener.util;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = ALPHABET.length();

    public String encode(long id){
        StringBuilder sb = new StringBuilder();

        if (id == 0){
            return String.valueOf(ALPHABET.charAt(0));
        }
        while (id > 0){
            int remainder = (int) (id % BASE);
            sb.append(ALPHABET.charAt(remainder));
            id /= BASE;
        }
        return sb.reverse().toString();
    }

    public long decode(String str){
        long num = 0;

        for (int i = 0; i < str.length(); i++){
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        }
        return num;
    }
}
