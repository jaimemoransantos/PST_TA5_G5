package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.InputStreamReader;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void categoria(View view){
        Intent i = new Intent(this, CategoriaC.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }
    public void perfil(View view){
        Intent i = new Intent(this, Perfil.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }
    public void principal(View view){
        Intent i = new Intent(this, Principal.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }

    public void  salir(View view){
        finish();
    }
}