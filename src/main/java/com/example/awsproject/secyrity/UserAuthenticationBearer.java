package com.example.awsproject.secyrity;



import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import reactor.core.publisher.Mono;

import java.util.List;



//после check в earerTokenServerAuthenticationConverter  создаем Authentication и закидваем его в MONO, таким обращом получаем доступ к сис_
// даже при условии закрытого endPoint
public class UserAuthenticationBearer {
    public static Mono<Authentication> create(JwtHandler.VerificationResult verificationResult) {
        Claims claims = verificationResult.claims;
        String subject = claims.getSubject();
        String role = (String) claims.get("role");
        String username = (String) claims.get("username");
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role));
        Long principalId = Long.parseLong(subject);
        CustomPrincipal principal = new CustomPrincipal(principalId, username);
        return Mono.justOrEmpty(new UsernamePasswordAuthenticationToken(principal, null, authorities));
    }
}
