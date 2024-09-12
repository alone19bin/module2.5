package com.example.awsproject.UserServiceTest;

import com.example.awsproject.model.IUser;
import com.example.awsproject.model.enums.Role;
import com.example.awsproject.model.enums.Status;
import com.example.awsproject.repository.UserRepository;
import com.example.awsproject.service.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    private IUser user;

    @BeforeEach
    void initUser() {
        user = IUser.builder()
                .id(1L)
                .username("user@user.com")
                .role(Role.USER)
                .firstName("bbbb")
                .lastName("bnnnnnn")
                .status(Status.ACTIVE)
                .enabled(true)
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }

    @Test
    void findBy_should_return_single_user() {
        userService.registerUser(user);
        IUser iUser = userService.getUserById(1L).block();
        when(userRepository.findById(1L).thenReturn(iUser));


    }
}
