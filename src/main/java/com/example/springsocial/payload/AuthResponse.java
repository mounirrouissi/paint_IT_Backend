package com.example.springsocial.payload;

import com.example.springsocial.model.User;

public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    private User user;

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponse(LoginResponse loginResponse) {
        this.accessToken=loginResponse.token();
        this.user = loginResponse.user();
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
