package com.example.artistservice.application;

import com.example.artistservice.domain.entity.FavouriteArtist;
import com.example.artistservice.domain.repository.FavouriteArtistRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteArtistService {
    private final FavouriteArtistRepository favouriteArtistRepository;

    public FavouriteArtistService(FavouriteArtistRepository favouriteArtistRepository) {
        this.favouriteArtistRepository = favouriteArtistRepository;
    }

    public FavouriteArtist save(FavouriteArtist favouriteArtist) {
        return favouriteArtistRepository.save(favouriteArtist);
    }

    public Optional<FavouriteArtist> find(long id) {
        return favouriteArtistRepository.findById(id);
    }
}
