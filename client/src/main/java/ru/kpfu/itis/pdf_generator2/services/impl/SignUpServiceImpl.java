package ru.kpfu.itis.pdf_generator2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.pdf_generator2.dto.SignUpFormDto;
import ru.kpfu.itis.pdf_generator2.entities.User;
import ru.kpfu.itis.pdf_generator2.repositories.UsersRepository;
import ru.kpfu.itis.pdf_generator2.services.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUpUser(SignUpFormDto signUpFormDto) {

        User user = User.builder()
                .email(signUpFormDto.getEmail())
                .firstName(signUpFormDto.getName())
                .hashPassword(passwordEncoder.encode(signUpFormDto.getPassword()))
                .role(User.Role.USER)
                    .build();

        usersRepository.save(user);
    }

    @Override
    public boolean userWithSuchEmailExists(String email) {
        return usersRepository.existsByEmail(email);
    }

}
