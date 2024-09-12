package com.example.awsproject.repository;

import com.example.awsproject.model.IUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<IUser,Long> {
    Mono<IUser> findByUsername(String userName);
}
