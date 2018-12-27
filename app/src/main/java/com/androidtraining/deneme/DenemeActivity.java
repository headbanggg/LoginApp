package com.androidtraining.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                if (LoginHelper.isUserExist(userName, userPass)) {
                    Intent myIntent = new Intent(DenemeActivity.this, SecondActivity.class);
                    myIntent.putExtra("myusername", userName);
                    String favoriteColor= LoginHelper.favoriteColor;
                    myIntent.putExtra("myfavoritecolor",favoriteColor);
                    startActivity(myIntent);
                } else {
                    Toast.makeText(DenemeActivity.this, "wrong username or password", Toast.LENGTH_SHORT).show();
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
