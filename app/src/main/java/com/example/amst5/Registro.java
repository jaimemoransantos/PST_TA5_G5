package com.example.amst5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.text.DateFormat;

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
        prueba= (TextView) findViewById(R.id.prueba);

    }

    public void Registar(View V){
        String nombre= userName.getText().toString();
        String apellido= userApellido.getText().toString();
        String user= userUser.getText().toString();
        String pass= userPass.getText().toString();
        String mail= userMail.getText().toString();
        String genero= userGenero.getText().toString();

        FileOutputStream fos= null;
        String linea= nombre+","+apellido+","+user+","+pass+","+mail+","+genero;

    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("datos.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("data.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

        /*try {
            File root = new File(Environment.getExternalStorageDirectory(), "My Folder");
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, "info.txt"); // file path to save
            FileWriter writer = new FileWriter(filepath);
            writer.append(linea);
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }*/


        /*try {
            fos= openFileOutput(name,MODE_PRIVATE);

            fos.write(linea.getBytes());
            Toast.makeText(this, "Saved to "+ getFilesDir()+"/"+ name,Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    public void Mostrar(View V){
        FileInputStream fis=null;
        try {
            fis=openFileInput(name);
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            StringBuilder sb= new StringBuilder();
            String text;
            while((text=br.readLine())!= null){
                sb.append(text).append("\n");

            }
            prueba.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/


    //ya

}