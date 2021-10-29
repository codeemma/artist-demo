package com.example.artistservice.domain.repository;

import com.example.artistservice.domain.entity.FavouriteArtist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteArtistRepository extends JpaRepository<FavouriteArtist, Long> {
}
