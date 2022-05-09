package uz.wiut.keepme.service.jwt;

import uz.wiut.keepme.helper.CryptHelper;

import java.security.NoSuchAlgorithmException;

public class PasswordHelperImpl implements PasswordHelper {

    private final String passwordToken;

    public PasswordHelperImpl(String passwordToken) {
        this.passwordToken = passwordToken;
    }

    public String convert(String username, String password) throws NoSuchAlgorithmException {
        return CryptHelper.MD5(username + "_" + passwordToken + "_" + password);
    }
}