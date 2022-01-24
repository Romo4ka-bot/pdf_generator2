package ru.kpfu.itis.pdf_generator2.services;

import ru.kpfu.itis.pdf_generator2.dto.SignUpFormDto;

public interface SignUpService {

    void signUpUser(SignUpFormDto signUpFormDto);

    boolean userWithSuchEmailExists(String email);

}
