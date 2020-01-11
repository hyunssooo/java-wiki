package dev.smjeon.wiki.oauth.kakao.presentation;

import dev.smjeon.wiki.oauth.kakao.application.KakaoOauthResponse;
import dev.smjeon.wiki.oauth.kakao.application.KakaoOauthService;
import dev.smjeon.wiki.oauth.kakao.application.KakaoTokenInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoLoginController {
    private static final Logger logger = LoggerFactory.getLogger(KakaoLoginController.class);

    private final KakaoOauthService kakaoOauthService;

    public KakaoLoginController(KakaoOauthService kakaoOauthService) {
        this.kakaoOauthService = kakaoOauthService;
    }

    @GetMapping("/login/kakao")
    public ResponseEntity login() {
        String redirectUrl = kakaoOauthService.getAuthorizationUrl();
        logger.info("Redirect Uri: {}", redirectUrl);
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", redirectUrl).build();
    }

    @GetMapping("/oauth/kakao")
    public ResponseEntity oauth(@RequestParam("code") String code) {
        logger.info("authentication code: {}", code);
        KakaoTokenInfo token = kakaoOauthService.getToken(code);
        KakaoOauthResponse kakaoOauthResponse = kakaoOauthService.getUserInfo(token);

        logger.info("LoginController - Oauth Response: {}", kakaoOauthResponse);

        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/").build();
    }
}
