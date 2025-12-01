package com.valentin.gonzalez.url_shortener;

import com.valentin.gonzalez.url_shortener.service.ShortUrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UrlShortenerIntegrationTest {

    @Autowired
    private ShortUrlService service;

    @Test
    void testShortenerFlow(){
        String original = "https://www.youtube.com";

        String hash = service.shortenUrl(original);

        assertNotNull(hash);
        assertTrue(hash.length() > 0);

        String retrievedUrl = service.getOriginalUrl(hash);
        assertEquals(original, retrievedUrl);
    }
}
