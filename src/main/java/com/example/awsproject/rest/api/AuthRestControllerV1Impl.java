package com.example.awsproject.rest.api;

import com.example.awsproject.dto.AuthRequestDto;
import com.example.awsproject.dto.AuthResponseDto;
import com.example.awsproject.dto.IUserDto;
import com.example.awsproject.mapper.UserMapper;
import com.example.awsproject.model.IUser;
import com.example.awsproject.rest.AuthRestControllerV1;
import com.example.awsproject.secyrity.SecurityService;
import com.example.awsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthRestControllerV1Impl implements AuthRestControllerV1 {

    private final SecurityService securityService;
    private final UserService userService;
    private final UserMapper userMapper;



    //отдаем данные
    @Override
    @PostMapping("/register")
    public Mono<IUserDto> register(@RequestBody IUserDto dto) {
        IUser entity = userMapper.map(dto);
        return this.userService.registerUser(entity).map(userMapper::map);
    }


    //получаем AuthResponseDto, проваливаемя в securityService
    @Override
    @PostMapping("/login")
    public Mono<AuthResponseDto> login(@RequestBody AuthRequestDto dto) {
        return this.securityService
                .authenticate
                        (
                                dto.getUsername(), dto.getPassword()
                        )
                .flatMap(
                        tokenDetails -> Mono.just
                                (
                                        AuthResponseDto.builder()
                                                .userId(tokenDetails.getUserId())
                                                .token(tokenDetails.getToken())
                                                .issuedAt(tokenDetails.getIssuedAt())
                                                .expiresAt(tokenDetails.getExpiresAt())
                                                .build()
                                ));
    }

}
