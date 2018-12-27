package com.androidtraining.deneme;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Mine Kandil on 25.12.2018.
 */
public class LoginHelper {
    private static ArrayList<User> userList = new ArrayList<>();
static String favoriteColor;
 static boolean isUserExist=false;

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

    public static boolean issUserExist(String username, String password) {
        for(int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUserName())
                    && password.equals(userList.get(i).getPassword())) {
                favoriteColor=userList.get(i).getFavoriteColor();
                return true;
            }
        }
        return false;
    }


    public static boolean loginWithUsernameAndPassword(final Context context,RequestQueue requestQueue, String userName, String password){

        String url="https://egitimlogin.herokuapp.com/login";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username",userName);
            jsonObject.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("mine"+ response);
                isUserExist=true;


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                isUserExist=false;
            }
        });
        requestQueue.add(jsonObjectRequest);
        return isUserExist;
    }
















}











