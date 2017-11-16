package com.tcc.news.service.logic;

import com.tcc.news.service.consumer.AuthConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthConsumer authConsumer;

    public Object auth() {
        return authConsumer.auth();
    }

    public Object token(String authUri) {
        return authConsumer.token(authUri);
    }
}
