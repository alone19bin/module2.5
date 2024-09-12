package com.example.awsproject.rest;

import com.example.awsproject.dto.AuthRequestDto;
import com.example.awsproject.dto.AuthResponseDto;
import com.example.awsproject.dto.IUserDto;
import com.example.awsproject.mapper.UserMapper;
import com.example.awsproject.model.IUser;
import com.example.awsproject.secyrity.SecurityService;
import com.example.awsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


public interface AuthRestControllerV1 {
    Mono<IUserDto> register(IUserDto dto);
    Mono<AuthResponseDto> login(AuthRequestDto dto);
}
