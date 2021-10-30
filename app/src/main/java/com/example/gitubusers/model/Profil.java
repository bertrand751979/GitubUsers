package com.example.gitubusers.model;

import java.io.Serializable;

public class Profil implements Serializable {
    private String loginProfil;
    private String passwordProfil;

    public Profil(String loginProfil, String passwordProfil) {
        this.loginProfil = loginProfil;
        this.passwordProfil = passwordProfil;
    }

    public Profil(){}
    public String getLoginProfil() {
        return loginProfil;
    }

    public void setLoginProfil(String loginProfil) {
        this.loginProfil = loginProfil;
    }

    public String getPasswordProfil() {
        return passwordProfil;
    }

    public void setPasswordProfil(String passwordProfil) {
        this.passwordProfil = passwordProfil;
    }
}
