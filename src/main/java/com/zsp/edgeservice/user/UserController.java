package com.zsp.edgeservice.user;

import java.util.List;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("user")
    public Mono<User> getUser(@AuthenticationPrincipal OidcUser oidcUser) {
        var user = new User(
                oidcUser.getPreferredUsername(),
                oidcUser.getGivenName(),
                oidcUser.getFamilyName(),
                oidcUser.getClaimAsStringList("roles")
        );
        return Mono.just(user);
    }

//    @GetMapping("user")
//    public Mono<User> getUser() {
//        return ReactiveSecurityContextHolder.getContext()
//                .map(SecurityContext::getAuthentication)
//                .map(authentication -> (OidcUser) authentication.getPrincipal())
//                .map(oidcUser -> new User(
//                                oidcUser.getPreferredUsername(),
//                                oidcUser.getGivenName(),
//                                oidcUser.getFamilyName(),
//                                List.of("employee", "customer")
//                        )
//                );
//    }x
}