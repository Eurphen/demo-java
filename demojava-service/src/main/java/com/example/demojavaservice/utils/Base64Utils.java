package com.example.demojavacommon.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {
    private static final String CHARSET_NAME = "UTF-8";
    
    public static String encodeBase64(String text) throws UnsupportedEncodingException {
        byte[] textByte = text.getBytes(CHARSET_NAME);
        return Base64.getUrlEncoder().encodeToString(textByte);
    }

    public static String decodeBase64(String encodedText) throws UnsupportedEncodingException {
        return new String(Base64.getUrlDecoder().decode(encodedText), CHARSET_NAME);
    }
}