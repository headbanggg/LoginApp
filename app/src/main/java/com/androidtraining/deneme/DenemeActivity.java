package com.androidtraining.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DenemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);
        /**
         * activity_deneme.xml'de oluşturduğumuz viewları çekmek için findViewById metodunu kullanıyoruz.
         */
        final EditText userNameEditText = findViewById(R.id.etUserName);
        final EditText passwordEditText = findViewById(R.id.etPassword);
        Button loginButton = findViewById(R.id.btnLogin);
        Button registerButton = findViewById(R.id.btnRegister);
        /**
         * login butonuna tıklandığını algılayabilmek için setOnClickListener metodu ile yeni bir OnClickListener yaratıyoruz.
         */

        loginButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Butona tıklayınca yapmak istediğimiz şeyleri onClick metodunun içine yazıyoruz.
             */
            @Override
            public void onClick(View v) {

                String userName = userNameEditText.getText().toString();
                String userPass = passwordEditText.getText().toString();

                String url = "https://egitimlogin.herokuapp.com/login";

                RequestQueue requestQueue =Volley.newRequestQueue(DenemeActivity.this);

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("username",userName);
                    jsonObject.put("password",userPass);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String userName= response.getString("username");
                            String favColor = response.getString("favColor");
                            Intent intent = new Intent(DenemeActivity.this,SecondActivity.class);
                            intent.putExtra("username",userName);
                            intent.putExtra("favcolor",favColor);
                            startActivity(intent);
                        } catch (JSONException e) {
                            try {
                                String errorstring = response.getString("message");
                                Toast.makeText(DenemeActivity.this, errorstring, Toast.LENGTH_SHORT).show();
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DenemeActivity.this, "Hatalı kullanıcı adı veya şifre", Toast.LENGTH_SHORT).show();
                    }
                });

                requestQueue.add(jsonObjectRequest);

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myInt = new Intent(DenemeActivity.this, RegisterActivity.class);
                startActivity(myInt);
            }
        });

    }
}
