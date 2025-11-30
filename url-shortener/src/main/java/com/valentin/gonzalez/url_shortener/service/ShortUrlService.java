package com.valentin.gonzalez.url_shortener.service;

import com.valentin.gonzalez.url_shortener.entity.ShortUrl;
import com.valentin.gonzalez.url_shortener.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShortUrlService {

    private final ShortUrlRepository repository;

    public ShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    public String shortenUrl(String originalUrl){
        String hash = UUID.randomUUID().toString().substring(0,8);

        ShortUrl url = new ShortUrl();
        url.setHash(hash);
        url.setOriginalUrl(originalUrl);

        repository.save(url);

        return hash;
    }

    public String getOriginalUrl(String hash){
        return repository.findByHash(hash)
                .map(ShortUrl::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}
