package dev.smjeon.wiki.oauth.github.application;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class GithubTokenInfo {
    @SerializedName("access_token")
    protected String accessToken;

    @SerializedName("token_type")
    protected String tokenType;

    @SerializedName("scope")
    private String scope;

    public GithubTokenInfo(String accessToken, String tokenType, String scope) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.scope = scope;
    }
}
