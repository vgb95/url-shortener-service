package com.valentin.gonzalez.url_shortener.repository;

import com.valentin.gonzalez.url_shortener.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlRepository  extends JpaRepository<ShortUrl, Long> {

    Optional<ShortUrl> findByHash(String hash);
}
