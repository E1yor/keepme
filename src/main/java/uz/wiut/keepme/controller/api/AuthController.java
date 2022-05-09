package uz.wiut.keepme.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.wiut.keepme.config.GrantTypeEnum;
import uz.wiut.keepme.dto.UserLoginFormDto;
import uz.wiut.keepme.service.jwt.UserSessionService;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private final UserSessionService userSessionService;
    private final HttpServletRequest servletRequest;

    public AuthController(UserSessionService userSessionService, HttpServletRequest servletRequest) {
        this.userSessionService = userSessionService;
        this.servletRequest = servletRequest;
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserLoginFormDto loginForm) {
        try {
            LOG.info(loginForm.toString());
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userSessionService.loginAndReturnToken(loginForm));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/logged/token")
    public ResponseEntity loggedByToken(String token) {
        try {
            LOG.info("LoggedByToken: " + token);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userSessionService.loggedByToken(token));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/login/refresh")
    public ResponseEntity<?> refreshToken(String refreshToken) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userSessionService.loginAndReturnToken(null, GrantTypeEnum.refresh_token, refreshToken));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

    @GetMapping(value = "/login/logout")
    public ResponseEntity<?> logout(String token) {
        try {
            userSessionService.logout(token);
            SecurityContextHolder.getContext().setAuthentication(null);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(e.getMessage());
        }
    }

}