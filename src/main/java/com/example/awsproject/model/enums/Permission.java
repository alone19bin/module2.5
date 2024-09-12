package com.example.awsproject.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    USER_READ("user:read"),

    USER_WRITE("user:write");
    private final String permission;
}
