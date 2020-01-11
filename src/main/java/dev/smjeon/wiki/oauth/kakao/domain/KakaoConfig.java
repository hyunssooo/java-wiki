package dev.smjeon.wiki.oauth.kakao.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:kakao.yml")
@ConfigurationProperties(prefix = "kakao.client")
@Getter
@Setter
public class KakaoConfig {
    private String clientId;
    private String clientSecret;
    private String authorizationUrl;
    private String accessTokenUrl;
    private String userInfoUrl;
    private String redirectUrl;
    private String logOutUrl;
}
