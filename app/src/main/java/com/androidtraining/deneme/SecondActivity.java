package com.androidtraining.deneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String favoritecolor= intent.getStringExtra("favcolor");
        TextView tvWelcome = findViewById(R.id.tvWelcome);

        tvWelcome.setText("Hello "+ username);
        if (favoritecolor.equals("Red")){
            tvWelcome.setTextColor(getColor(R.color.colorRed));
        }
        else if(favoritecolor.equals("Blue")){
            tvWelcome.setTextColor(getColor(R.color.colorBlue));
        }
        else {
            tvWelcome.setTextColor(getColor(R.color.colorGreen));
        }

    }
}
