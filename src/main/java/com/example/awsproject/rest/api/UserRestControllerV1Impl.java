package com.example.awsproject.rest.api;

import com.example.awsproject.model.IUser;
import com.example.awsproject.rest.UserRestControllerV1;
import com.example.awsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users/")
public class UserRestControllerV1Impl implements UserRestControllerV1 {

    private final UserService userService;
    @Override
    @GetMapping("/{id}")
    public Mono<IUser> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }
    @Override
    @GetMapping
    public Flux<IUser> getAll() {
        return this.userService.getAll();
    }
    @Override
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return this.userService.deleteById(id);
    }
}

