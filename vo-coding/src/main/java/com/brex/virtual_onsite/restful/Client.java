package com.brex.virtual_onsite.restful;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.brex.virtual_onsite.model.BrexTestWrapper;
import com.fasterxml.jackson.databind.*;

public class Client {

    private final ObjectMapper mapper = new ObjectMapper();

    public void performRequest() {
        try {
            final HttpRequest request = setupRequest();
            final HttpResponse<String> response = getResponse(request);
            if (response.body() != null) {
                String json = response.body();
                BrexTestWrapper value = mapper.readValue(json, BrexTestWrapper.class);
                System.out.println(value);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static HttpResponse<String> getResponse(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newBuilder()
                .build().send(request, HttpResponse.BodyHandlers.ofString());
    }

    private HttpRequest setupRequest() {
        return setupRequest(null);
    }

    private HttpRequest setupRequest(String url) {
        final String requestUrl = url == null ? "https://platform.brexapis.com/interview/test" : url;
        final URI brexUri = URI.create(requestUrl);
        return HttpRequest.newBuilder()
                .uri(brexUri)
                .header("Accept", "application/json")
                .GET()
                .build();
    }

}
