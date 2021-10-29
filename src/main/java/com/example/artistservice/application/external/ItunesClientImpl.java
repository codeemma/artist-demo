package com.example.artistservice.application.external;

import com.example.artistservice.config.ItunesClientProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Component
@RequiredArgsConstructor
public class ItunesClientImpl implements ItunesClient {

    private final ItunesClientProperty clientProperty;
    private final RestTemplate restTemplate;

    @Override
    public Map search(String term) {
        UriComponents uriComponents = fromUriString(clientProperty.getBaseUrl())
                .path("/search?entity=allArtist&term={term}")
                .buildAndExpand(term);
        return restTemplate.postForObject(uriComponents.toString(), null, Map.class);
    }

    @Override
    public Map findTop5Album(long artistId) {
        UriComponents uriComponents = fromUriString(clientProperty.getBaseUrl())
                .path("/lookup?entity=album&limit=5&amgArtist={artistId}")
                .buildAndExpand(artistId);
        return restTemplate.postForObject(uriComponents.toString(), null, Map.class);
    }
}
