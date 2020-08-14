package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Prueba Alexis Cando

    }

    public void registro(View view){
        Intent i = new Intent(this, Registro.class );
        startActivity(i);
    }
    public void ingresar(View view){
        Intent prin = new Intent(MainActivity.this, Principal.class );
        startActivity(prin);
    }
}