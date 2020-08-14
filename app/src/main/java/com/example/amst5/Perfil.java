package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import java.io.InputStreamReader;

public class Perfil extends AppCompatActivity {
    TextView tUsuario,tNombre,tApellido,tCorreo,tCelular,tFavorito;
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
        tUsuario.setText(bundle.getString("usuario"));
        tNombre.setText(bundle.getString("password"));
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        //String passw= ingresoContrasena.getText().toString();
        //String user1 = ingresoUser.getText().toString();
        //user1="'"+user1+"'";
        //Cursor fila = bd.rawQuery(
        //        "select contrase from datos where user=" + user1, null);
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