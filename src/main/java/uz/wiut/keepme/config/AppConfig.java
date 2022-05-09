package uz.wiut.keepme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uz.wiut.keepme.service.jwt.PasswordHelper;
import uz.wiut.keepme.service.jwt.PasswordHelperImpl;
import uz.wiut.keepme.service.jwt.TokenHelper;
import uz.wiut.keepme.service.jwt.TokenHelperImpl;

@Configuration
public class AppConfig {

    private final JwtConfig jwtConfig;

    private String passwordToken = "ccm-emr-api";

    public AppConfig(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Bean
    public PasswordHelper password() {
        return new PasswordHelperImpl(passwordToken);
    }

    @Bean
    public TokenHelper token() { return new TokenHelperImpl(jwtConfig); }

}
