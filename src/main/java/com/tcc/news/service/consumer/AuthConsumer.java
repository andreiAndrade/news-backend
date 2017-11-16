package com.tcc.news.service.consumer;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tcc.news.dto.RefreshTokenResponseDto;
import com.tcc.news.utils.FeedlyApi;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthConsumer extends AbstractServiceConsumer{

    private final String GRANT_TYPE_KEY = "grant_type";
    private final String CLIENT_SECRET_KEY = "client_secret";
    private final String CLIENT_ID_KEY = "client_id";
    private final String REDIRECT_URI_KEY = "redirect_uri";
    private final String SCOPE_KEY = "scope";
    private final String RESPONSE_TYPE_KEY = "response_type";
    private final String CODE_KEY = "code";

    private final String GRANT_TYPE = "authorization_code";
    private final String CLIENT_SECRET = "0XP4XQ07VVMDWBKUHTJM4WUQ";
    private final String CLIENT_ID = "feedly";
    private final String REDIRECT_URI = "https://cloud.feedly.com/feedly.html";
//    private final String REDIRECT_URI = "localhost:8080/api/auth/token";
    private final String REDIRECT_URI_2 = "http://www.feedly.com/feedly.html";
    private final String SCOPE = "https://cloud.feedly.com/subscriptions";
    private final String RESPONSE_TYPE = "code";

    public String auth() {
        Map<String, Object> params = new HashMap<>();
        params.put(CLIENT_ID_KEY, CLIENT_ID);
        params.put(REDIRECT_URI_KEY, REDIRECT_URI);
        params.put(SCOPE_KEY, SCOPE);
        params.put(RESPONSE_TYPE_KEY, RESPONSE_TYPE);

        return get(new ParameterizedTypeReference<String>() {
        }, FeedlyApi.Resources.AUTH_AUTH, params);
    }

    public JSONPObject token(String code) {
        Map<String, Object> body = new HashMap<>();
        body.put(CLIENT_ID_KEY, CLIENT_ID);
        body.put(CLIENT_SECRET_KEY, CLIENT_SECRET);
        body.put(GRANT_TYPE_KEY, GRANT_TYPE);
        body.put(REDIRECT_URI_KEY, REDIRECT_URI_2);
        body.put(CODE_KEY, code);

        return post(new ParameterizedTypeReference<JSONPObject>() {
        }, FeedlyApi.Resources.AUTH_TOKEN, body);
    }
}
