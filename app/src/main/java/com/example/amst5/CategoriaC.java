package com.example.amst5;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;


public class CategoriaC extends AppCompatActivity {
    String libros=null;


    //prueba Sheyla
    Intent intent= getIntent();
    Bundle args=intent.getBundleExtra("Bundle");
    ArrayList<Libro> libros_iterar=(ArrayList<Libro>) args.getSerializable("ARRAYLIST");






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

    }

    public void mostrar(){
        for (Libro l: libros_iterar){
            libros=l.getAutor();
        }

    }


    //botones
    public void categoria(View view) {
        //prueba Sheyla
        Intent i= new Intent(this,CategoriaC.class);
        startActivity(i);
        finish();
    }

    public void perfil(View view) {
        Intent i = new Intent(this, Perfil.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }

    public void principal(View view) {
        Intent i = new Intent(this, Principal.class);
        //i.putExtra("direccion", et1.getText().toString());
        startActivity(i);
        finish();
    }
    public void click_libro(View view) {
        mostrarDialogo();
    }
    public void mostrarDialogo(){
        AlertDialog.Builder builder= new AlertDialog.Builder(CategoriaC.this);
        builder.setTitle("Libros");
        builder.setMessage(libros)
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .show();

    }

}
