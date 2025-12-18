package com.valentin.gonzalez.url_shortener.controller;


import com.valentin.gonzalez.url_shortener.service.ShortUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class ShortUrlController {

    private final ShortUrlService service;

    public ShortUrlController(ShortUrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestBody String originalUrl){
        String hash = service.shortenUrl(originalUrl);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("http://localhost:8080/api/v1/" + hash);
    }

    @GetMapping("/{hash}")
    public ResponseEntity<Void> redirect(@PathVariable String hash){
        String originalUrl = service.getOriginalUrl(hash);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }


}
