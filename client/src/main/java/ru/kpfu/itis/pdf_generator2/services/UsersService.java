package ru.kpfu.itis.pdf_generator2.services;

import ru.kpfu.itis.pdf_generator2.entities.User;

public interface UsersService {
    void blockUser(Long userId);
    User getUser(Long userId);
}
