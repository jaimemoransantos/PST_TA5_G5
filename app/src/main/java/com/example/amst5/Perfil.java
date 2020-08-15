package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Perfil extends AppCompatActivity {
    TextView tUsuario,tNombre,tApellido,tCorreo,tCelular,tFavorito;
    String user;
    Bundle bundle;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        bundle=getIntent().getExtras();

        tUsuario=(TextView)findViewById(R.id.textUsuario);
        tNombre=(TextView)findViewById(R.id.textNombre);
        tApellido=(TextView)findViewById(R.id.textApellido);
        tCorreo=(TextView)findViewById(R.id.textCorreo);
        tCelular=(TextView)findViewById(R.id.textCelular);
        tFavorito=(TextView)findViewById(R.id.textFavorito);
        assert bundle != null;
        user=bundle.getString("usuario");
        tUsuario.setText(user);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "grupo5", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();


        Cursor fila = bd.rawQuery(
                "select nombre,apellido,email,genero,numTel from info where user=" + user, null);
        if (fila.moveToFirst()) {
            tNombre.setText("Nombre: "+ fila.getString(0));
            tApellido.setText("Apellido: "+fila.getString(1));
            tCorreo.setText("Correo: "+fila.getString(2));
            tFavorito.setText("Favorito: "+fila.getString(3));
            tCelular.setText("Telefono: "+fila.getString(4));

        }
        bd.close();



    }
    public void categoria(View view){
        Intent i = new Intent(this, CategoriaC.class);
        startActivity(i);
        finish();
    }
    public void perfil(View view){
        Toast toast1 = Toast.makeText(getApplicationContext(), "Ya se encuentra dentro de Perfil", Toast.LENGTH_SHORT);
        toast1.show();
    }
    public void principal(View view){
        Intent i = new Intent(this, Principal.class);
        i.putExtra("user",user);
        setResult(RESULT_OK,i);
        finish();
    }
    public  void  salir(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}