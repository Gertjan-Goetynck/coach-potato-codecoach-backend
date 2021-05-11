package com.switchfully.codecoach.domain;

import com.switchfully.codecoach.security.authentication.user.Authority;
import com.switchfully.codecoach.security.authentication.user.api.Account;

import java.util.List;

public class MockAccount implements Account {
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String encode) {

    }

    @Override
    public List<Authority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountEnabled() {
        return false;
    }

    @Override
    public void enableAccount() {

    }
}
