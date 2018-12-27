package com.androidtraining.deneme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etName = findViewById(R.id.etRegisterName);
        final EditText etPass = findViewById(R.id.etRegisterPassword);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        final RadioGroup rg = findViewById(R.id.rgColors);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUserName = etName.getText().toString();
                String newUserPass = etPass.getText().toString();
                int id = rg.getCheckedRadioButtonId();
                String newFavoriteColor = ((RadioButton) findViewById(id)).getText().toString();

                User newUser = new User(newUserName, newUserPass, newFavoriteColor);
                if (LoginHelper.addNewUser(newUser)) {
                    Toast.makeText(getApplicationContext(), "user added " , Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getApplicationContext(), "wrong username " + newFavoriteColor, Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
