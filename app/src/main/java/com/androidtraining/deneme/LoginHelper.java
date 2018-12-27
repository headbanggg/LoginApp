package com.androidtraining.deneme;

import java.util.ArrayList;

/**
 * Created by Mine Kandil on 25.12.2018.
 */
public class LoginHelper {
    private static ArrayList<User> userList = new ArrayList<>();
static String favoriteColor;

    public static boolean addNewUser(User myNewUser) {
        boolean isUserVarMi = isUserNameExist(myNewUser.getUserName());
        if (!isUserVarMi) {
            userList.add(myNewUser);
            return true;
        }
        return false;
    }

    public static boolean isUserExist(String username, String password) {
        for(int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())
                    && password.equals(userList.get(i).getPassword())) {
                favoriteColor=userList.get(i).getFavoriteColor();
                return true;
            }
        }
        return false;
    }

    public static boolean isUserNameExist(String username) {
        for(int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())) {

                return true;
            }
        }
        return false;
    }


















}











