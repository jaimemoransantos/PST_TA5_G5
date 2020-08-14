package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Registro extends AppCompatActivity {
    private static final String name= "info.txt";
    EditText userName;
    EditText userApellido;
    EditText userUser;
    EditText userPass;
    EditText userMail;
    EditText userGenero;
    TextView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        userName= (EditText) findViewById(R.id.nombre);
        userApellido= (EditText) findViewById(R.id.apellido);
        userUser= (EditText) findViewById(R.id.user);
        userPass= (EditText) findViewById(R.id.contra);
        userMail= (EditText) findViewById(R.id.correo);
        userGenero= (EditText) findViewById(R.id.genero);


    }
    //Funciones de base de datos
    public void ingresar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nom= userName.getText().toString();
        String apel= userApellido.getText().toString();
        String usuario= userUser.getText().toString();
        String pass= userPass.getText().toString();
        String mail= userMail.getText().toString();
        String gene= userGenero.getText().toString();
        bd.execSQL("insert into datos (nombre,apellido,user,contrase,email,genero) values ("
                +"'"+nom+"','"+apel+"','"+usuario+"','"+pass+"','"+mail+"','"+gene+"'"+")");
        bd.close();
        userName.setText("");
        userApellido.setText("");
        userUser.setText("");
        userPass.setText("");
        userMail.setText("");
        userGenero.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }

    public void consultaporNombre(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String namee = userName.getText().toString();
        namee="'"+namee+"'";
        Cursor fila = bd.rawQuery(
                "select apellido,user,contrase,email,genero from datos where nombre=" + namee, null);
        if (fila.moveToFirst()) {
            userApellido.setText(fila.getString(0));
            userUser.setText(fila.getString(1));
            userPass.setText(fila.getString(2));
            userMail.setText(fila.getString(3));
            userGenero.setText(fila.getString(4));
        } else
            Toast.makeText(this, "No existe un artículo con dicho código",
                    Toast.LENGTH_SHORT).show();
        bd.close();
    }


    public void eliminar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nam= userName.getText().toString();
        nam="'"+nam+"'";
        bd.execSQL("delete from datos where nombre = "+nam);
        bd.close();
        userName.setText("");
        userApellido.setText("");
        userUser.setText("");
        userPass.setText("");
        userMail.setText("");
        userGenero.setText("");
        Toast.makeText(this, "Se borró el artículo con dicho código",
                Toast.LENGTH_SHORT).show();
    }
    public void regresar(View v){
        finish();
    }

}
