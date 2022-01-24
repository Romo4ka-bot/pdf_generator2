package ru.kpfu.itis.pdf_generator2.services;

/**
 * 09.04.2021
 * 52. JwtRedis
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface JwtBlacklistService {
    void add(String token);

    boolean exists(String token);
}
