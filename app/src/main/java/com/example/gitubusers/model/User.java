package com.example.gitubusers.model;

import java.io.Serializable;

public class User implements Serializable {
    private String avatar_url;
    private String login;
    private String url;

    public User(String avatar_url, String login, String url) {
        this.avatar_url = avatar_url;
        this.login = login;
        this.url = url;
    }

    public User(){}

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
