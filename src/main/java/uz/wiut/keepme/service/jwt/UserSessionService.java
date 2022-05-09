package uz.wiut.keepme.service.jwt;

import uz.wiut.keepme.config.GrantTypeEnum;
import uz.wiut.keepme.dto.JwtTokenDto;
import uz.wiut.keepme.dto.UserLoginFormDto;
import uz.wiut.keepme.dto.UserDto;

public interface UserSessionService {
    UserDto loggedByToken(String token) throws Exception;
    UserDto loggedBySession(String sessionId) throws Exception;
    JwtTokenDto loginAndReturnToken(UserLoginFormDto loginForm) throws Exception;
    JwtTokenDto loginAndReturnToken(UserDto formDto, GrantTypeEnum grantType, String refreshToken) throws Exception;
    void logout(String token) throws Exception;
}
