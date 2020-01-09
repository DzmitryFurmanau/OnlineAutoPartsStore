package com.onlineAutoPartsStore.app.dto.response;

/**
 * The type Token response dto.
 */
public class TokenResponseDto {

    private String token;

    private String type = "Bearer";

    /**
     * Instantiates a new Token response dto.
     *
     * @param accessToken the access token
     */
    public TokenResponseDto(String accessToken) {
        this.token = accessToken;
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public String getAccessToken() {
        return token;
    }

    /**
     * Sets access token.
     *
     * @param accessToken the access token
     */
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    /**
     * Gets token type.
     *
     * @return the token type
     */
    public String getTokenType() {
        return type;
    }

    /**
     * Sets token type.
     *
     * @param tokenType the token type
     */
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}
