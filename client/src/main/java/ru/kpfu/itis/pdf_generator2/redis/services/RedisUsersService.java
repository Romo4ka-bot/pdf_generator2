package ru.kpfu.itis.pdf_generator2.redis.services;

import ru.kpfu.itis.pdf_generator2.entities.User;

public interface RedisUsersService {
    void addTokenToUser(User user, String token);

    void addAllTokensToBlackList(User user);
}
