package com.example.artistservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "itunes-client")
public class ItunesClientProperty {

    private String baseUrl;
}
