package com.example.sharon.sweetapp;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.sharon.sweetapp.BaseDatos.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Registrar extends AppCompatActivity {

    Button btnGrabarUsu;
    private EditText edtNombre;
    private EditText edtUsuario;
    private EditText edtPassword;
    private EditText edtEdad;

    DBHelper helper=new DBHelper(this,"BD1",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnGrabarUsu=(Button)findViewById(R.id.tvv_registro);
        edtNombre = (EditText) findViewById(R.id.tvv_nombree);
        edtUsuario = (EditText) findViewById(R.id.tvv_usuario);
        edtPassword = (EditText) findViewById(R.id.tvv_password);
        edtEdad = (EditText) findViewById(R.id.tvv_edadd);

        btnGrabarUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.abrir();
                helper.insertarReg(String.valueOf(edtNombre.getText()),
                        String.valueOf(edtUsuario.getText()),
                        String.valueOf(edtPassword.getText()),
                        String.valueOf(edtEdad.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro almacenado con exito"
                        ,Toast.LENGTH_LONG).show();

                Intent i=new Intent(getApplicationContext(),ActLogin.class);
                startActivity(i);
            }
        });
    }



}



