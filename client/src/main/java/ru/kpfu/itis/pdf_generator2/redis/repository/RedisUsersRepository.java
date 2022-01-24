package ru.kpfu.itis.pdf_generator2.redis.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.kpfu.itis.pdf_generator2.redis.models.RedisUser;

public interface RedisUsersRepository extends KeyValueRepository<RedisUser, String> {
}
