package com.example.api1.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    @Override
    <S extends User> S save(S s);
}
