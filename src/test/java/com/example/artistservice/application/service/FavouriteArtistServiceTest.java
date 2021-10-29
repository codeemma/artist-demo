package com.example.artistservice.application.service;

import com.example.artistservice.application.FavouriteArtistService;
import com.example.artistservice.domain.entity.FavouriteArtist;
import com.example.artistservice.domain.repository.FavouriteArtistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class FavouriteArtistServiceTest {
    @MockBean
    private FavouriteArtistRepository favouriteArtistRepository;

    @Autowired
    private FavouriteArtistService favouriteArtistService;

    @Test
    void shouldSaveFavouriteArtist() {
        FavouriteArtist favouriteArtist = createFavouriteArtist();
        when(favouriteArtistRepository.save(favouriteArtist)).thenReturn(favouriteArtist);

        favouriteArtistService.save(favouriteArtist);

        verify(favouriteArtistRepository).save(favouriteArtist);
    }

    private FavouriteArtist createFavouriteArtist() {
        return FavouriteArtist.builder().userId(UUID.randomUUID().toString()).artistId(1233L).build();
    }

}