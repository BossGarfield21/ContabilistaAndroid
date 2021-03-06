package com.example.hugomocho.teste1;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class RegisterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText textRegistarNome = (EditText) findViewById(R.id.textRegistarNome);
        final EditText textRegistarID = (EditText) findViewById(R.id.textRegistarID);
        final EditText textRegistarPassword = (EditText) findViewById(R.id.textRegistarPassword);
        final Button buttonRegistar = (Button) findViewById(R.id.buttonRegistar);


        buttonRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nome = textRegistarNome.getText().toString();
                final String id = textRegistarID.getText().toString();
                final String password = textRegistarPassword.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");


                            if(nome.equals("") || password.equals("") || id.equals("")){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Campos incompletos")
                                        .create()
                                        .show();
                            } else

                            if(success){
                                Intent registarIntent = new Intent(RegisterActivity.this, MainActivity.class);
                                RegisterActivity.this.startActivity(registarIntent);
                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registo falhado")
                                        .setNegativeButton("Tentar outra vez", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                if(!(nome.equals("") || password.equals("") || id.equals(""))) {
                    RegisterRequest registerRequest = new RegisterRequest(nome, id, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);
                }
            }
        });

    }
}
