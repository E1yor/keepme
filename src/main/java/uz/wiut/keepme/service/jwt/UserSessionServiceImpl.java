package uz.wiut.keepme.service.jwt;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import uz.wiut.keepme.config.*;

import javax.security.auth.message.AuthException;
import org.springframework.util.StringUtils;
import uz.wiut.keepme.domain.User;
import uz.wiut.keepme.domain.UserSession;
import uz.wiut.keepme.dto.JwtTokenDto;
import uz.wiut.keepme.dto.UserDto;
import uz.wiut.keepme.dto.UserLoginFormDto;
import uz.wiut.keepme.helper.GuidHelper;
import uz.wiut.keepme.helper.StringHelper;
import uz.wiut.keepme.repository.UserRepository;
import uz.wiut.keepme.repository.UserSessionRepository;

import java.util.Optional;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    private final Gson gson;
    private final UserSessionRepository userSessionRepository;
    private final UserRepository userRepository;
    private final TokenHelper tokenHelper;
    private final JwtConfig jwtConfig;

    public UserSessionServiceImpl(Gson gson, UserSessionRepository userSessionRepository, UserRepository userRepository, TokenHelper tokenHelper, JwtConfig jwtConfig) {
        this.gson = gson;
        this.userSessionRepository = userSessionRepository;
        this.userRepository = userRepository;
        this.tokenHelper = tokenHelper;
        this.jwtConfig = jwtConfig;
    }

    @Override
    public UserDto loggedByToken(String token) throws Exception {
        String sessionId = tokenHelper.retrieveSessionId(token);
        Optional<UserSession> o_us = userSessionRepository.findById(sessionId);
        if (o_us == null || !o_us.isPresent()){
            System.out.println("loggedByToken method");
            throw new Exception("User session not found.");
        }
        return gson.fromJson(o_us.get().getValue(), UserDto.class);
    }

    @Override
    public UserDto loggedBySession(String sessionId) throws Exception {
        Optional<UserSession> o_us = userSessionRepository.findById(sessionId);
        if (o_us == null || !o_us.isPresent()){
            System.out.println("logged method");
            throw new Exception("User session not found.");
        }
        return gson.fromJson(o_us.get().getValue(), UserDto.class);
    }

    @Override
    public JwtTokenDto loginAndReturnToken(UserLoginFormDto loginForm) throws Exception {
        Optional<User> o_u = userRepository.findFirstByUsername(loginForm.getUsername());
        if(o_u == null || !o_u.isPresent()){
            System.out.println("unauthorized username");
            throw new Exception("unauthorized username");
        }

        boolean passwordMatch = o_u.get().getPassword().equals(loginForm.getPassword());
        if(!passwordMatch){
            System.out.println("incorrect password");
            throw new Exception("incorrect password");
        }

        String userDataJson = gson.toJson(o_u.get());
        String sessionId = GuidHelper.get();

        UserSession userSession = new UserSession(sessionId, userDataJson);
        userSession = userSessionRepository.save(userSession);

        String accessToken = tokenHelper.generate(userSession.getId());
        String refreshTokenNew = tokenHelper.generateRefreshToken(userSession.getId());

        return new JwtTokenDto(accessToken, "Bearer", refreshTokenNew, "read write", jwtConfig.getExpireTime());
    }

    @Override
    public JwtTokenDto loginAndReturnToken(UserDto formDto, GrantTypeEnum grantType, String refreshToken) throws Exception {
        if (grantType.equals(GrantTypeEnum.password)) {
            if (StringHelper.get(formDto.getUsername()) == null) {
                throw new AuthException("username bo'sh bo'lmasligi lozim");
            }

            String sessionId = GuidHelper.get();

            String json = gson.toJson(formDto);
            UserSession newUserSession = new UserSession(sessionId, json);
            UserSession userSession = userSessionRepository.save(newUserSession);

            String accessToken = tokenHelper.generate(userSession.getId());
            String refreshTokenNew = tokenHelper.generateRefreshToken(userSession.getId());

            return new JwtTokenDto(accessToken, "Bearer", refreshTokenNew, "read write", jwtConfig.getExpireTime());
        }

        if (grantType.equals(GrantTypeEnum.refresh_token)) {

            if (!StringUtils.hasText(refreshToken)) {
                throw new AuthException("Refresh token bo'sh bo'lmasligi lozim");
            }
            String sessionId = tokenHelper.retrieveRefreshSessionId(refreshToken);
            Optional<UserSession> o_us = userSessionRepository.findById(sessionId);
            if(o_us == null || !o_us.isPresent())
                throw new AuthException("Ushbu token bo'yicha foydalanuvchi ma'lumotlari topilmadi");

            userSessionRepository.deleteById(o_us.get().getId());

            sessionId = GuidHelper.get();
            String accountDetailJson = o_us.get().getValue();
            UserSession userSession = new UserSession(sessionId, accountDetailJson);

            UserSession newUserSession = userSessionRepository.save(userSession);
            String accessToken = tokenHelper.generate(newUserSession.getId());
            String refreshTokenNew = tokenHelper.generateRefreshToken(newUserSession.getId());

            return new JwtTokenDto(accessToken, "Bearer", refreshTokenNew, "read write", jwtConfig.getExpireTime());
        }

        throw new AuthException("grantType topilmadi");
    }

    @Override
    public void logout(String token) throws Exception {
        String sessionId = tokenHelper.retrieveSessionId(token);
        Optional<UserSession> o_us = userSessionRepository.findById(sessionId);
        if (o_us == null || !o_us.isPresent()){
            System.out.println("logout method");
            throw new Exception("User session not found.");
        }

        userSessionRepository.deleteById(o_us.get().getId());

    }

}
