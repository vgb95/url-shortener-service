package com.valentin.gonzalez.url_shortener.service;

import com.valentin.gonzalez.url_shortener.entity.ShortUrl;
import com.valentin.gonzalez.url_shortener.repository.ShortUrlRepository;
import com.valentin.gonzalez.url_shortener.util.Base62Encoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShortUrlService {

    private final ShortUrlRepository repository;
    private final Base62Encoder base62Encoder;

    public ShortUrlService(ShortUrlRepository repository, Base62Encoder base62Encoder) {
        this.repository = repository;
        this.base62Encoder = base62Encoder;
    }

    public String shortenUrl(String originalUrl){
        ShortUrl url = new ShortUrl();
        url.setOriginalUrl(originalUrl);
        url.setHash("temporal");

        ShortUrl savedUrl = repository.save(url);
        String hash = base62Encoder.encode(savedUrl.getId());
        savedUrl.setHash(hash);
        repository.save(savedUrl);

        return hash;
    }

    public String getOriginalUrl(String hash){
       /* return repository.findByHash(hash)
                .map(ShortUrl::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));*/
        long id = base62Encoder.decode(hash);
        ShortUrl shortUrl = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("URL no encontrada"));

        shortUrl.setClicks(shortUrl.getClicks() + 1);
        repository.save(shortUrl);

        return shortUrl.getOriginalUrl();
    }


}
