package dev.smjeon.wiki.oauth.kakao.application;

import lombok.Getter;

@Getter
public class KakaoOauthResponse {
    private Long id;
    private String nickName;

    public KakaoOauthResponse(Long id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }
}
