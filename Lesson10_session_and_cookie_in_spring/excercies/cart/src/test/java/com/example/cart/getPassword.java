package com.example.cart;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class getPassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password="123";
        String mahoaCode = bCryptPasswordEncoder.encode(password);
        System.out.println(mahoaCode);
    }
}
