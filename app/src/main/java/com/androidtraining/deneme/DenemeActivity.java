package com.androidtraining.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

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
        final RequestQueue requestQueue= Volley.newRequestQueue(DenemeActivity.this);
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
               boolean isUserExist= LoginHelper.loginWithUsernameAndPassword(DenemeActivity.this,requestQueue,userName,userPass);

                if (isUserExist){
                    Toast.makeText(DenemeActivity.this, "user exist", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(DenemeActivity.this, "wrong username or password" , Toast.LENGTH_LONG).show();
                }

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
