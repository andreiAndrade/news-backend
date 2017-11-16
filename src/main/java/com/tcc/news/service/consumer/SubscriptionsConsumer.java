package com.tcc.news.service.consumer;

import com.tcc.news.dto.SubscriptionDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscriptionsConsumer extends AbstractServiceConsumer {

    public List<SubscriptionDto> list(String token) {
        Map<String, String> header = new HashMap();
        header.put("Authorization", "Bearer " + token);

        final HttpEntity<?> entity = new HttpEntity<>(buildHeaders(header));

        ResponseEntity<List<SubscriptionDto>> response = restClient.exchange(uriWithResource("/subscriptions"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<SubscriptionDto>>(){});
        return response.getBody();
    }
}
