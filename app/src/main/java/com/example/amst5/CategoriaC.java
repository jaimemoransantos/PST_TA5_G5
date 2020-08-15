package com.example.amst5;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class CategoriaC extends AppCompatActivity {
    ImageButton bterror,bromance,bficcion,bcuento;
    String libros="sheyla";

   String[] libros_iterar;
    ArrayList<Libro> basedatos = new ArrayList<>();
    ArrayList<String> lib = new ArrayList<>();









    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Bundle bundle=getIntent().getExtras();
        libros_iterar=bundle.getStringArray("arrayst");


    }

    public void mostrar(String categoria) {

        for(String s : libros_iterar){
            String[] cortado = s.split("\\|");
            basedatos.add(new Libro(cortado[0], cortado[3], cortado[1], cortado[2], cortado[4], cortado[5]));
            String l = cortado[0]+" " +cortado[1]+" " + cortado[2]+" " + cortado[3]+" " + cortado[4]+" " + cortado[5];
            System.out.println(l);
        }
        for (Libro l:basedatos){
            if (l.getCategoria().equals(categoria)){
                lib.add(l.getAutor());
                lib.add(l.getEditorial());
                lib.add(l.getRuta());
                lib.add(l.getSinopsis());
                lib.add(l.getTitulo());

            }
        }




    }


    //botones
    public void categoria(View view) {
        Intent ic= new Intent(this,CategoriaC.class);
        ic.putExtra("arrayst",libros_iterar);
        startActivity(ic);
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
       // mostrar();
       // mostrarDialogo();
        if ((getResources().getResourceEntryName(view.getId()).equals("imageButtonCuento"))){
            mostrar("Cuento");
            mostrarDialogo();
        }else if ((getResources().getResourceEntryName(view.getId()).equals("imageButtonTerror"))){
            mostrar("Terror");
            mostrarDialogo();
        }else if((getResources().getResourceEntryName(view.getId()).equals("imageButtonFiccion"))){
            mostrar("Ficción");
            mostrarDialogo();
        }else if((getResources().getResourceEntryName(view.getId()).equals("imageButtonRomance"))){
            mostrar("Romance");
            mostrarDialogo();
        }



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
