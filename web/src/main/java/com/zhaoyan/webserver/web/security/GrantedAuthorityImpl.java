package com.zhaoyan.webserver.web.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;
    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
