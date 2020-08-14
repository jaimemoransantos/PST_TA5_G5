package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Bundle bundle=getIntent().getExtras();

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
            tNombre.setText(fila.getString(0));
            tApellido.setText(fila.getString(1));
            tCorreo.setText(fila.getString(2));
            tFavorito.setText(fila.getString(3));
            tCelular.setText(fila.getString(4));

        }
        bd.close();



    }
    public void categoria(View view){
        Intent i = new Intent(this, CategoriaC.class);
        startActivity(i);
        finish();
    }
    public void perfil(View view){
        Intent i = new Intent(this, Perfil.class);

        startActivity(i);
        finish();
    }
    public void principal(View view){
        Intent i = new Intent(this, Principal.class);
        startActivity(i);
        finish();
    }
    public  void  salir(View view){
        finish();
    }

}