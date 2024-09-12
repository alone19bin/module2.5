package com.example.awsproject.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN(Set.of(Permission.USER_READ,Permission.USER_WRITE)),
    USER(Set.of(Permission.USER_READ,Permission.USER_WRITE)),
    MODERATOR(Set.of(Permission.USER_READ,Permission.USER_WRITE));

    private final Set<Permission> permissions;
    private final Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission ->
                        new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }

}
