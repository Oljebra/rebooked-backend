package com.personal.rebooked.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BrevoService {

    @Value("${brevo.api.key}")
    private String apiKey;

    @Value("${brevo.api.url}")
    private String apiUrl;


    private WebClient webClient() {
        System.out.println(apiUrl);
        return WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("api-key", apiKey)
                .build();
    }


    public Object addToMailingList(String email, List<Integer> listIDs) {
        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("listIds", listIDs);
        body.put("updateEnabled", true);
        WebClient webClient = webClient();
        return webClient.post()
                .uri("/contacts")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Object.class)
                .block();
    }
}
