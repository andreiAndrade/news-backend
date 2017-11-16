package com.tcc.news.service.consumer;

import com.tcc.news.dto.StreamDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedConsumer extends AbstractServiceConsumer{

    public StreamDto list(String token, String subscriptionId) {
        Map<String, String> header = new HashMap();
        header.put("Authorization", "Bearer " + token);

        final HttpEntity<?> entity = new HttpEntity<>(buildHeaders(header));

        Map<String, Object> params = new HashMap();
        params.put("streamId", subscriptionId);
        params.put("count", 5);

        ResponseEntity<StreamDto> response = restClient.exchange(
            buildURIWithParams(uriWithResource("/streams/contents"), params),
            HttpMethod.GET, entity, new ParameterizedTypeReference<StreamDto>() {}
        );
        return response.getBody();
    }
}
