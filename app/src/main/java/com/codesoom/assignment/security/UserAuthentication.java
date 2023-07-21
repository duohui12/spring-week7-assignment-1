package com.codesoom.assignment.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserAuthentication extends AbstractAuthenticationToken {

    private final Long userId;

    public UserAuthentication(Long userId, List<String> roles) {
        super(authorities(roles));
        this.userId = userId;
    }

    private static List<GrantedAuthority> authorities(List<String> roles) {
        //return roles.stream().map(SimpleGrantedAuthority::new)
        //        .collect(Collectors.toList());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userId;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

}
