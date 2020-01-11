package dev.smjeon.wiki.oauth.kakao.application;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class KakaoTokenInfo {
    @SerializedName("access_token")
    protected String accessToken;

    @SerializedName("token_type")
    protected String tokenType;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("expires_in")
    private String expiresIn;

    @SerializedName("scope")
    private String scope;

    @SerializedName("refresh_token_expires_in")
    private String refreshTokenExpiresIn;

    public KakaoTokenInfo(String accessToken, String tokenType, String refreshToken,
                          String expiresIn, String scope, String refreshTokenExpiresIn) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }
}
