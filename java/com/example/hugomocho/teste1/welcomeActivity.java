package com.example.hugomocho.teste1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class welcomeActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        final TextView etID = (TextView) findViewById(R.id.cheID);
        final TextView etnome = (TextView) findViewById(R.id.chenome);
        final Button bWelcome = (Button) findViewById(R.id.bWelcome);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String nomeUsuario = intent.getStringExtra("nomeUsuario");

        etID.setText(nome);
        etnome.setText(nomeUsuario);

        bWelcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(welcomeActivity.this, PrimeiroMenuActivity.class);
                welcomeActivity.this.startActivity(mainIntent);
            }
        });


    }

}
