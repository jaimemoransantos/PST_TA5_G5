package com.example.amst5;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class CategoriaC extends AppCompatActivity {
    ImageButton bterror,bromance,bficcion,bcuento;
    String libros="sheyla";
    Bundle bundle;
    String user;

   String[] libros_iterar;
    ArrayList<Libro> basedatos = new ArrayList<>();
    ArrayList<Libro> lib_filtrada = new ArrayList<>();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Bundle bundle=getIntent().getExtras();
        libros_iterar=bundle.getStringArray("arrayst");
        user=bundle.getString("usuario");


    }

    public void mostrar(String categoria) {
        lib_filtrada.clear();
        for(String s : libros_iterar){
            String[] cortado = s.split("\\|");
            basedatos.add(new Libro(cortado[0], cortado[3], cortado[1], cortado[2], cortado[4], cortado[5]));
            String l = cortado[0]+" " +cortado[1]+" " + cortado[2]+" " + cortado[3]+" " + cortado[4]+" " + cortado[5];
            System.out.println(l);
        }
        for (Libro l:basedatos){
            if (l.getCategoria().equals(categoria)){
                lib_filtrada.add(new Libro(l.getTitulo(),l.getCategoria(),l.getAutor(),l.getEditorial(),l.getSinopsis(),l.getRuta()));

            }
        }




    }


    //botones
    public void categoria(View view) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "Ya se encuentra dentro de Categoria", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void perfil(View view) {
        Intent i = new Intent(this, Perfil.class);
        i.putExtra("user",user);
        setResult(RESULT_OK,i);
        finish();
    }

    public void principal(View view) {
        Intent i = new Intent(this, Principal.class);
        i.putExtra("user",user);
        setResult(RESULT_OK,i);
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
        LinearLayout mio=new LinearLayout(getApplicationContext());
        mio.removeAllViews();
        mio.setOrientation(LinearLayout.VERTICAL);
        for (Libro l: lib_filtrada){

            LinearLayout llh = new LinearLayout(mio.getContext());
            llh.setOrientation(LinearLayout.HORIZONTAL);
            ImageView fotito = new ImageView(llh.getContext());
            String nombre = "@drawable/" + l.getRuta();
            int recurso = getResources().getIdentifier(nombre,null, getPackageName());
            fotito.setImageResource(recurso);
            fotito.setPadding(15,10,15, 10);
            LinearLayout llv = new LinearLayout(llh.getContext());
            llv.setOrientation(LinearLayout.VERTICAL);
            TextView titulo = new TextView(llv.getContext());
            titulo.setText(l.getTitulo());
            titulo.setPadding(15,10,15, 10);
            //System.out.println(l.getTitulo());
            TextView autor = new TextView(llv.getContext());
            autor.setText(l.getAutor());
            autor.setPadding(15,10,15, 10);
            //System.out.println(l.getAutor());
            TextView editorial = new TextView(llv.getContext());
            editorial.setText(l.getEditorial());
            editorial.setPadding(15,10,15, 10);
            //System.out.println(l.getEditorial());
            TextView categoria = new TextView(llv.getContext());
            categoria.setText(l.getCategoria());
            categoria.setPadding(15,10,15, 10);
            //System.out.println(l.getCategoria());
            //System.out.println(l.getRuta());
            //System.out.println();
            llv.addView(titulo);
            llv.addView(autor);
            llv.addView(editorial);
            llv.addView(categoria);
            llh.addView(fotito);
            llh.addView(llv);
            mio.addView(llh);
        }

        builder.setView(mio.getRootView())
        //builder.setMessage(libros)
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
