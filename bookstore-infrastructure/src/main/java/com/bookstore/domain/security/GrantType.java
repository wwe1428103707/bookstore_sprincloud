package com.bookstore.domain.security;

/**
 * OAuth2 授权类型
 **/
public interface GrantType {

    // 标准类型
    String PASSWORD = "password";
    String CLIENT_CREDENTIALS = "client_credentials";
    String IMPLICIT = "implicit";
    String AUTHORIZATIONCODE = "authorizationcode";
    // 刷新令牌
    String REFRESH_TOKEN = "refresh_token";

}