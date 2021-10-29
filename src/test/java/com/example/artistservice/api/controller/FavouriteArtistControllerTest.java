package com.example.artistservice.api.controller;

import com.example.artistservice.api.model.ExternalArtist;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FavouriteArtistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        when(restTemplate.postForObject(anyString(), eq(null), eq(Map.class)))
                .thenReturn(Map.of("data", "test"));
    }

    @Test
    public void createShouldReturnSuccess() throws Exception {
        mockMvc.perform(post("/v1/artists")
                .contentType("application/json")
                .header("user-id", "123er")
                .content(objectMapper.writeValueAsString(new ExternalArtist(123L))))
                .andExpect(status().isCreated());
    }

    @Test
    public void createShouldReturnBadrequestOnMissingHeader() throws Exception {
        mockMvc.perform(post("/v1/artists")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(new ExternalArtist(123L))))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void searchShouldReturnDataOnSearch() throws Exception {
        mockMvc.perform(get("/v1/artists/search").queryParam("term", "terms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", is("test")));
    }

    @Test
    public void searchShouldReturnDataOnFindTop5Album() throws Exception {
        mockMvc.perform(get("/v1/artists/123/top5-album"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", is("test")));
    }

}