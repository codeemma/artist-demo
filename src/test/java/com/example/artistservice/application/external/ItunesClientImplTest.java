package com.example.artistservice.application.external;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ItunesClientImplTest {

    @Autowired
    private ItunesClient itunesClient;
    @MockBean
    private RestTemplate restTemplate;

    @Test
    void shouldCallItunesSearchApi() {
        var uri = "https://itunes.apple.com/search?entity=allArtist&term=term";
        when(restTemplate.postForObject(uri, null, Map.class))
                .thenReturn(Map.of());

        var result = itunesClient.search("term");

        verify(restTemplate).postForObject(uri, null, Map.class);
        assertNotNull(result);
    }

    @Test
    void shouldCallItuneLookUpApi() {
        var uri = "https://itunes.apple.com/lookup?entity=album&limit=5&amgArtist=123";
        when(restTemplate.postForObject(uri, null, Map.class))
                .thenReturn(Map.of());

        var result = itunesClient.findTop5Album(123);

        verify(restTemplate).postForObject(uri, null, Map.class);
        assertNotNull(result);
    }
}