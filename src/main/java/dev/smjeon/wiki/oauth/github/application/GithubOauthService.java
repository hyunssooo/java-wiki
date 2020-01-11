package dev.smjeon.wiki.oauth.github.application;

import com.google.gson.Gson;
import dev.smjeon.wiki.oauth.github.domain.GithubConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GithubOauthService {
    private static final Logger logger = LoggerFactory.getLogger(GithubOauthService.class);

    private final GithubConfig githubConfig;

    public GithubOauthService(GithubConfig githubConfig) {
        this.githubConfig = githubConfig;
    }

    public String getAuthorizationUrl() {
        return githubConfig.getAuthorizationUrl() + "?client_id=" + githubConfig.getClientId();
    }

    public GithubTokenInfo getToken(String code) {
        String body = WebClient.create(githubConfig.getAccessTokenUrl())
                .post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("client_id", githubConfig.getClientId())
                        .queryParam("client_secret", githubConfig.getClientSecret())
                        .queryParam("code", code)
                        .build())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        logger.info("Token Info: {}", body);
        return new Gson().fromJson(body, GithubTokenInfo.class);
    }

    public GithubOauthResponse getUserInfo(GithubTokenInfo tokenInfo) {
        String body = WebClient.create(githubConfig.getUserInfoUrl())
                .get()
                .header("Authorization", "token " + tokenInfo.getAccessToken())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        logger.info("User Response: {}", body);

        return new Gson().fromJson(body, GithubOauthResponse.class);
    }
}
