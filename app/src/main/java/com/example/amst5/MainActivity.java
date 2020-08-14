package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ingresoUser;
    EditText ingresoContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingresoUser=(EditText) findViewById(R.id.usuario);
        ingresoContrasena=(EditText) findViewById(R.id.contrasena);

    }

    public void registro(View view){
        Intent i = new Intent(this, Registro.class );
        startActivity(i);


    }
    public void ingresar(View view){
        Intent prin = new Intent(MainActivity.this, Principal.class );
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String passw= ingresoContrasena.getText().toString();
        String user1 = ingresoUser.getText().toString();
        user1="'"+user1+"'";
        Cursor fila = bd.rawQuery(
                "select contrase from datos where user=" + user1, null);
        if (fila.moveToFirst()) {
            String password= fila.getString(0);
            if (password.equals(passw)){
                startActivity(prin);
            }else
                Toast.makeText(this, "Contraseña incorrecta",
                        Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(this, "No existe un artículo con dicho Usuario",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }
}