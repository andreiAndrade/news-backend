package com.tcc.news.service.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceConsumer {

    private static final String TOKEN_KEY = "x-auth-token";

    public RestTemplate restClient;

    @Value("${feedly.address}")
    private String feedlyAddress;

    @Value("${feedly.version}")
    private String feedlyVersion;

    @Value("${feedly.protocol}")
    private String feedlyProtocol;

    @PostConstruct
    public void postConstruct() {
        this.restClient = new RestTemplate();
        this.restClient.setErrorHandler(new ErrorHandler());
    }

    private <T> ResponseEntity<T> exchange(String resource, Map<String, Object> params, HttpMethod method, HttpEntity<?> entity, Class<T> clazz) {
        return this.restClient.exchange(
                buildURIWithParams(uriWithResource(resource), params),
                method,
                entity,
                clazz);
    }

    private <T> ResponseEntity<T> exchange(String resource, HttpMethod method, HttpEntity<?> entity, ParameterizedTypeReference<T> clazz) {
        return this.restClient.exchange(
                uriWithResource(resource),
                method,
                entity,
                clazz);
    }

    private <T> ResponseEntity<T> exchange(String resource, HttpMethod method, HttpEntity<?> entity, Class<T> clazz) {
        return this.restClient.exchange(
                uriWithResource(resource),
                method,
                entity,
                clazz);
    }

    private <T> ResponseEntity<T> exchange(String resource, Map<String, Object> params, HttpMethod method, HttpEntity<?> entity, ParameterizedTypeReference<T> clazz) {
        return this.restClient.exchange(
                buildURIWithParams(uriWithResource(resource), params),
                method,
                entity,
                clazz);
    }

    protected <T> T get(final Class<T> clazz, final String resource, final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(buildHeaders());
        return this.exchange(resource, params, HttpMethod.GET, entity, clazz).getBody();
    }

    protected <T> T get(final ParameterizedTypeReference<T> clazz, final String resource,
                        final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(buildHeaders());
        return this.exchange(resource, params, HttpMethod.GET, entity, clazz).getBody();
    }

    protected <T> T get(final Class<T> clazz, final String resource, final Object body, final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange( resource, params, HttpMethod.GET, entity, clazz).getBody();
    }

    protected <T> T get(final ParameterizedTypeReference<T> clazz, final String resource, final Object body,
                        final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, params, HttpMethod.GET, entity, clazz).getBody();
    }

    protected <T> T post(final Class<T> clazz, final String resource, final Object body) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, HttpMethod.POST, entity, clazz).getBody();
    }

    protected <T> T post(final Class<T> clazz, final String resource, final Object body, final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, params, HttpMethod.POST, entity, clazz).getBody();
    }

    protected <T> T postHeader(final ParameterizedTypeReference<T> clazz, final String resource, final Map<String, String> header, final Object body) {

        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders(header));
        return this.exchange(resource, HttpMethod.POST, entity, clazz).getBody();
    }

    protected <T> T post(final ParameterizedTypeReference<T> clazz, final String resource, final Object body) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, HttpMethod.POST, entity, clazz).getBody();
    }

    protected <T> T post(final ParameterizedTypeReference<T> clazz, final String resource, final Object body, final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, params, HttpMethod.POST, entity, clazz).getBody();
    }

    protected <T> T put(final Class<T> clazz, final String resource, final Object body) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, HttpMethod.PUT, entity, clazz).getBody();
    }

    protected <T> T put(final Class<T> clazz, final String resource, final Object body, Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, params,HttpMethod.PUT, entity, clazz).getBody();
    }

    protected <T> T put(final ParameterizedTypeReference<T> clazz, final String resource, final Object body) {
        final HttpEntity<?> entity = new HttpEntity<>(body, buildHeaders());
        return this.exchange(resource, HttpMethod.PUT, entity, clazz).getBody();
    }

    protected <T> T put(final ParameterizedTypeReference<T> clazz, final String resource, final Object body,
                        final Map<String, Object> params) {
        final HttpEntity<?> entity = new HttpEntity<>(body, this.buildHeaders());
        return this.exchange(resource, params, HttpMethod.PUT, entity, clazz).getBody();
    }

    protected Map<String, Object> getMapParams(final String key, final Object obj) {
        final Map<String, Object> map = new HashMap<>();
        map.putIfAbsent(key, obj);
        return map;
    }

    private HttpHeaders buildHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        return headers;
    }

    public HttpHeaders buildHeaders(Map<String, String> header) {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        header.forEach((key, value) -> headers.set(key, value));

        return headers;
    }

    public URI buildURIWithParams(final String uri, final Map<String, Object> params) {
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);

        params.forEach((key, value) -> {
            builder.queryParam(key, value);
        });

        return builder.build().toUri();
    }

    public String uriWithResource(final String resource) {

        return new StringBuffer(this.feedlyProtocol)
                .append("://")
                .append(this.feedlyAddress)
                .append(this.feedlyVersion)
                .append(resource)
                .append("/")
                .toString();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> Collection<T> convert(final Collection iter, final Class<T> clazz) {
        final Collection<T> list = new ArrayList<>();
        list.addAll(iter);
        return list;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T, Y> Map<T, Y> convert(final Map map, final Class<T> clazzT, final Class<Y> clazzY) {
        return new HashMap<>(map);
    }

    private class ErrorHandler implements ResponseErrorHandler{

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            //Do nothing;
        }

    }
}
