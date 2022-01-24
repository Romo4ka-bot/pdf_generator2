package ru.kpfu.itis.pdf_generator2.repositories;

public interface BlacklistRepository {
    void save(String token);

    boolean exists(String token);
}
