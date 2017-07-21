package com.example.hugomocho.teste1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PrimeiroMenuActivity extends AppCompatActivity {

    String[] cartoes = {"MarceloCard", "MochãoCard", "PoliceCard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeiro_menu);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cartoes);

        ListView listView = (ListView) findViewById(R.id.listaCartoes);
        listView.setAdapter(adapter);

    }
}
