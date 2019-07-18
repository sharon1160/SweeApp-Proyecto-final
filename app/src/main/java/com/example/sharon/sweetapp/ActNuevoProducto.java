package com.example.sharon.sweetapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.example.sharon.sweetapp.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActNuevoProducto extends AppCompatActivity {

    EditText campoId,campoNombre,campoPrecio,campoMarca;

    Button btnregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_nuevo_producto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        campoId=(EditText)findViewById(R.id.edtID);
        campoNombre=(EditText)findViewById(R.id.edtNombre);
        campoPrecio=(EditText)findViewById(R.id.edtPrecio);
        campoMarca=(EditText)findViewById(R.id.edtMarca);

        btnregistro=findViewById(R.id.btnRgistro);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarProductos();
                Intent i = new Intent(getApplicationContext(),ActMain.class);
                startActivity(i);
            }
        });

    }

    private void registrarProductos() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_productos",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,campoPrecio.getText().toString());
        values.put(Utilidades.CAMPO_MARCA,campoMarca.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_PRODUCTO,Utilidades.CAMPO_ID,values);


        Toast.makeText(getApplicationContext(),"Se ha registrado un producto",Toast.LENGTH_LONG).show();

        db.close();
    }

}
