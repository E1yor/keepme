package uz.wiut.keepme.service.jwt;

import java.security.NoSuchAlgorithmException;

public interface PasswordHelper {
    String convert(String email, String password) throws NoSuchAlgorithmException;
}
