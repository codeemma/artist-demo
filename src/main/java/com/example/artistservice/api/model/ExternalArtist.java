package com.example.artistservice.api.model;

import com.example.artistservice.domain.entity.FavouriteArtist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExternalArtist {

    @NonNull
    private Long artistId;

    public FavouriteArtist toInternal(String userId) {
        return FavouriteArtist.builder()
                .artistId(this.artistId)
                .userId(userId).build();
    }
}
