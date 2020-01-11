package dev.smjeon.wiki.oauth.kakao.application;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.smjeon.wiki.oauth.kakao.domain.KakaoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KakaoOauthService {
    private static final Logger logger = LoggerFactory.getLogger(KakaoOauthService.class);

    private final KakaoConfig kakaoConfig;

    public KakaoOauthService(KakaoConfig kakaoConfig) {
        this.kakaoConfig = kakaoConfig;
    }

    public String getAuthorizationUrl() {
        return kakaoConfig.getAuthorizationUrl() +
                "?client_id=" +
                kakaoConfig.getClientId() +
                "&redirect_uri=" +
                kakaoConfig.getRedirectUrl() +
                "&response_type=code";
    }

    public KakaoTokenInfo getToken(String code) {
        String body = WebClient.create(kakaoConfig.getAccessTokenUrl())
                .post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("client_id", kakaoConfig.getClientId())
                        .queryParam("client_secret", kakaoConfig.getClientSecret())
                        .queryParam("redirect_uri", kakaoConfig.getRedirectUrl())
                        .queryParam("code", code)
                        .build())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        logger.info("Token Info: {}", body);

        return new Gson().fromJson(body, KakaoTokenInfo.class);
    }

    public KakaoOauthResponse getUserInfo(KakaoTokenInfo tokenInfo) {
        String body = WebClient.create(kakaoConfig.getUserInfoUrl())
                .post()
                .header("Authorization", "Bearer " + tokenInfo.getAccessToken())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        logger.info("KAKAO Response: {}", body);

        Long id = Long.parseLong(new JsonParser().parse(body).getAsJsonObject().get("id").getAsString());
        JsonObject properties = new JsonParser().parse(body).getAsJsonObject().get("properties").getAsJsonObject();

        return new KakaoOauthResponse(id, properties.get("nickname").getAsString());
    }
}
