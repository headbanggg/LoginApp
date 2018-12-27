package com.androidtraining.deneme;

/**
 * Created by Mine Kandil on 25.12.2018.
 */
public class User {

    private String userName;
    private String password;
    private String favoriteColor;

    public User(String userName, String password, String favoriteColor) {
        this.userName = userName;
        this.password = password;
        this.favoriteColor = favoriteColor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }
}
