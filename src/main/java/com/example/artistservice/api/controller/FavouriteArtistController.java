package com.example.artistservice.api.controller;

import com.example.artistservice.api.model.ExternalArtist;
import com.example.artistservice.application.FavouriteArtistService;
import com.example.artistservice.application.external.ItunesClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Map;

@Validated
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "v1/artists", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavouriteArtistController {

    private final FavouriteArtistService favouriteArtistService;
    private final ItunesClient itunesClient;

    @PostMapping
    public ResponseEntity<?> create(@RequestHeader("user-id") String userId, @RequestBody @Valid ExternalArtist body) {
        log.debug("create() received, artist = {}, userId = {}", body, userId);
        favouriteArtistService.save(body.toInternal(userId));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public Map search(@RequestParam("term") String term) {
        log.debug("search() received, term = {}", term);

        return itunesClient.search(term);
    }

    @GetMapping("/{artistId}/top5-album")
    public Map findTop5Album(@PathVariable @Min(1) long artistId) {
        log.debug("findTop5Album() received, artistId = {}", artistId);

        return itunesClient.findTop5Album(artistId);
    }
}
