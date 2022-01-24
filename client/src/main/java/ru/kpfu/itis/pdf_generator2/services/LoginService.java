package ru.kpfu.itis.pdf_generator2.services;

import ru.kpfu.itis.pdf_generator2.dto.EmailPasswordDto;
import ru.kpfu.itis.pdf_generator2.dto.TokenDto;

public interface LoginService {
    TokenDto login(EmailPasswordDto emailPassword);
}
