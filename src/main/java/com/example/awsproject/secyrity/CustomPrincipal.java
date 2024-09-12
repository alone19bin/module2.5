package com.example.awsproject.secyrity;

import lombok.*;

import java.security.Principal;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomPrincipal implements Principal {

    private Long id;
    private String name;
}
