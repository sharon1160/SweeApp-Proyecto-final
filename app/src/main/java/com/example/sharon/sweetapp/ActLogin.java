package com.example.sharon.sweetapp;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.Button;

import com.example.sharon.sweetapp.BaseDatos.DBHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import android.database.Cursor;

import android.widget.EditText;
import android.widget.Toast;


import android.database.sqlite.SQLiteDatabase;

public class ActLogin extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtPassword;



    TextView tv_iniciar;
    TextView tv_registrar;

    DBHelper helper=new DBHelper(this,"BD1",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        tv_iniciar = findViewById(R.id.tvv_inicial);
        tv_registrar=findViewById(R.id.tvv_registrar);

        tv_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (campos()) {
                    try {
                        Cursor cursor = helper.ConsultarUsuPas(edtUsuario.getText().toString(), edtPassword.getText().toString());
                        if (cursor.getCount() > 0) {
                            Intent i = new Intent(getApplicationContext(), ActMain.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario y/o Pass incorrectos ", Toast.LENGTH_LONG).show();
                        }
                        edtUsuario.setText("");
                        edtPassword.setText("");
                        edtUsuario.findFocus();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Campo(s) vacio(s) ", Toast.LENGTH_LONG).show();

                }
            }
        });

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Registrar.class);
                startActivity(i);
            }
        });

    }
    private boolean campos(){
        boolean res = true;
        if(edtUsuario.getText().toString().isEmpty()){
            Toast.makeText(this, "Campo(s) vacio(s)",Toast.LENGTH_LONG).show();
            res=false;
        }else {
            if(edtPassword.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo(s) vacio(s)", Toast.LENGTH_LONG).show();
                res=false;
            }
        }
        return res;
    }

}


