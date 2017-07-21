package com.example.hugomocho.teste1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import static android.R.attr.button;
import static com.example.hugomocho.teste1.R.id.buttonLogin;
import static com.example.hugomocho.teste1.R.id.textRegistar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText textLoginID = (EditText) findViewById(R.id.textLoginID);
        final EditText textLoginPass = (EditText) findViewById(R.id.textLoginPass);
        final TextView textRegistar = (TextView) findViewById(R.id.textRegistar);
        final Button buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String nomeUsuario = textLoginID.getText().toString();
                final String password = textLoginPass.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){

                                String nome = jsonResponse.getString("nome");

                                Intent registarIntent = new Intent(MainActivity.this, welcomeActivity.class);
                                registarIntent.putExtra("nome", nome);
                                registarIntent.putExtra("nomeUsuario", nomeUsuario);
                                MainActivity.this.startActivity(registarIntent);

                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("Dados incorretos")
                                        .setNegativeButton("Tente outra vez", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(nomeUsuario, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });

        textRegistar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent registarIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registarIntent);
            }
        });


    }
}
