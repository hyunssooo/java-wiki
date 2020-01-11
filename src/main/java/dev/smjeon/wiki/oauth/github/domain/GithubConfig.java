package dev.smjeon.wiki.oauth.github.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:github.yml")
@ConfigurationProperties(prefix = "github.client")
@Getter
@Setter
public class GithubConfig {
    private String clientId;
    private String clientSecret;
    private String authorizationUrl;
    private String accessTokenUrl;
    private String userInfoUrl;
    private String redirectUrl;
}
