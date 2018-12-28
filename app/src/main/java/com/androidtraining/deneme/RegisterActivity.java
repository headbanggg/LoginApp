package com.androidtraining.deneme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etName = findViewById(R.id.etRegisterName);
        final EditText etPass = findViewById(R.id.etRegisterPassword);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        final RadioGroup rg = findViewById(R.id.rgColors);

        final String baseurl = "https://egitimlogin.herokuapp.com/user";


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUserName = etName.getText().toString();
                String newUserPass = etPass.getText().toString();
                int id = rg.getCheckedRadioButtonId();
                String newFavoriteColor = ((RadioButton) findViewById(id)).getText().toString();


                RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);

                JSONObject jsonObject =new JSONObject();
                try {
                    jsonObject.put("username",newUserName);
                    jsonObject.put( "password",newUserPass);
                    jsonObject.put("favColor", newFavoriteColor);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, baseurl, jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(RegisterActivity.this, "Kullanıcı eklendi.", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "Kullanıcı oluşturulamadı.", Toast.LENGTH_LONG).show();
                    }
                });

                requestQueue.add(jsonObjectRequest);

            }
        });
    }
}
