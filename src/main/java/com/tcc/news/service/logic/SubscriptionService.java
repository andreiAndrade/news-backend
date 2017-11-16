package com.tcc.news.service.logic;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tcc.news.dto.SubscriptionDto;
import com.tcc.news.service.consumer.SubscriptionsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionsConsumer subscriptionsConsumer;

    public List<SubscriptionDto> list(String token) {
        return subscriptionsConsumer.list(token);
    }
}