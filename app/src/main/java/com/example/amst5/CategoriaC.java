package com.example.amst5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class CategoriaC extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
    }
//codigo
public void lista(View view) {
    Intent i = new Intent(this, MainActivity.class );
    //i.putExtra("direccion", et1.getText().toString());
    startActivity(i);
    finish();
}
    public void principal(View view) {
        Intent i = new Intent(this, MainActivity.class );
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }
    public void perfil(View view) {
        Intent i = new Intent(this, MainActivity.class );
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }
}
