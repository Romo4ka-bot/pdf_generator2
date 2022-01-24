package ru.kpfu.itis.pdf_generator2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.pdf_generator2.entities.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
