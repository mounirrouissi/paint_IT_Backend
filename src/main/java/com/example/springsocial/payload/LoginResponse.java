package com.example.springsocial.payload;

import com.example.springsocial.model.User;

public record LoginResponse(String token, User user) {
}
