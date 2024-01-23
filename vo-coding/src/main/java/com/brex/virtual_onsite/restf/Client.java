package com.brex.virtual_onsite.restf;

import com.brex.virtual_onsite.model.BrexTestWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Named client to avoid clashing/confusing with "java.net.http.HttpClient".
 */
public class Client {

    private static final String BREX_TEXT_URL = "https://platform.brexapis.com/interview/test";
    private final ObjectMapper mapper = setupMapper();

    public void performRequest() {
        try {
            final HttpRequest request = setupRequest();
            final HttpResponse<String> response = getResponse(request);
            if (response.body() != null) {
                BrexTestWrapper value = parseResponse(response);
                System.out.println("Response: " + value);
            } else {
                System.out.println("Empty response body");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ObjectMapper setupMapper() {
        return new ObjectMapper().findAndRegisterModules();
    }

    private HttpRequest setupRequest() {
        return setupRequest(null);
    }

    private HttpRequest setupRequest(String url) {
        final String requestUrl = (url == null) ? BREX_TEXT_URL : url;
        final URI brexUri = URI.create(requestUrl);
        return HttpRequest.newBuilder()
                .uri(brexUri)
                .header("Accept", "application/json")
                .GET()
                .build();
    }

    private HttpResponse<String> getResponse(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newBuilder().build()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    private BrexTestWrapper parseResponse(HttpResponse<String> response) throws JsonProcessingException {
        return mapper.readValue(response.body(), BrexTestWrapper.class);
    }

}
