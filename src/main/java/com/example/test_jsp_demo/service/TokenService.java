package com.example.test_jsp_demo.service;

import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class TokenService {

    public static String generateHmacSignature(String secret, String data) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String signature = hmac256(secret,data);
        signature = "hmac256-" +signature;
// System.out.println("signature: "+signature);
        return signature;
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String hmac256(String secret, String message) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] encodedhash = sha256_HMAC.doFinal(message.getBytes("UTF8"));
// System.out.println("hmac256 : " +singature.toString());
        return bytesToHex(encodedhash);
    }



}
