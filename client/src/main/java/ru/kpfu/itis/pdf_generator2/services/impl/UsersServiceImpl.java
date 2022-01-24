package ru.kpfu.itis.pdf_generator2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.pdf_generator2.entities.User;
import ru.kpfu.itis.pdf_generator2.redis.services.RedisUsersService;
import ru.kpfu.itis.pdf_generator2.repositories.UsersRepository;
import ru.kpfu.itis.pdf_generator2.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RedisUsersService redisUsersService;

    @Override
    public void blockUser(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        redisUsersService.addAllTokensToBlackList(user);
    }

    @Override
    public User getUser(Long userId) {
        return usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
    }
}
