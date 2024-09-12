package com.example.awsproject.service;

import com.example.awsproject.model.IUser;
import com.example.awsproject.model.enums.Role;
import com.example.awsproject.repository.UserRepository;
import com.example.awsproject.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;


public interface UserService {
     Mono<IUser> registerUser(IUser user);
     Mono<IUser> getUserById(Long id);
     Mono<IUser> getUserByUsername(String username);
     Mono<Void> deleteById(Long id);
     Flux<IUser> getAll();

}
