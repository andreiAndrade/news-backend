package com.tcc.news.service.logic;

import com.tcc.news.dto.FeedDto;
import com.tcc.news.dto.StreamDto;
import com.tcc.news.dto.SubscriptionDto;
import com.tcc.news.dto.UserDto;
import com.tcc.news.service.consumer.FeedConsumer;
import com.tcc.news.service.consumer.SubscriptionsConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {
    @Autowired
    private FeedConsumer feedConsumer;
    @Autowired
    private SubscriptionsConsumer subscriptionsConsumer;

    public Object findFeed(String token) {
        List<SubscriptionDto> subscriptions =
                subscriptionsConsumer.list(token);
        List<StreamDto> feeds = new ArrayList();

        for (SubscriptionDto dto : subscriptions) {
            feeds.add(feedConsumer.list(token, dto.getId()));

        }

        return feeds;
    }
}



