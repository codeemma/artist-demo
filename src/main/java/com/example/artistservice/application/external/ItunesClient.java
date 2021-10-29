package com.example.artistservice.application.external;

import java.util.Map;

public interface ItunesClient {

    Map search(String term);

    Map findTop5Album(long artistId);
}
