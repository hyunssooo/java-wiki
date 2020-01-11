package dev.smjeon.wiki.oauth.github.presentation;

import dev.smjeon.wiki.oauth.github.application.GithubOauthResponse;
import dev.smjeon.wiki.oauth.github.application.GithubOauthService;
import dev.smjeon.wiki.oauth.github.application.GithubTokenInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GithubLoginController {
    private static final Logger logger = LoggerFactory.getLogger(GithubLoginController.class);

    private GithubOauthService githubOauthService;

    public GithubLoginController(GithubOauthService githubOauthService) {
        this.githubOauthService = githubOauthService;
    }

    @GetMapping("/login/github")
    public ResponseEntity login() {
        String redirectUrl = githubOauthService.getAuthorizationUrl();
        logger.info("Redirect Uri: {}", redirectUrl);
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", redirectUrl).build();
    }

    @GetMapping("/oauth/github")
    public ResponseEntity oauth(@RequestParam("code") String code) {
        logger.info("authentication code: {}", code);
        GithubTokenInfo token = githubOauthService.getToken(code);
        GithubOauthResponse oauthResponse = githubOauthService.getUserInfo(token);

        logger.info("LoginController - Oauth Response: {}", oauthResponse);

        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/").build();
    }
}
