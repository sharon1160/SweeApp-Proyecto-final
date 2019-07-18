package com.example.sharon.sweetapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.sharon.sweetapp.utilidades.Utilidades;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActConsultar extends AppCompatActivity {

    EditText campoId,campoNombre,campoPrecio,campoMarca;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_consultar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_productos",null,1);


        campoId=(EditText)findViewById(R.id.edtIde);
        campoNombre=(EditText)findViewById(R.id.edtnom);
        campoPrecio=(EditText)findViewById(R.id.edtpre);
        campoMarca=(EditText)findViewById(R.id.edtmar);



    }
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBuscar:
                consultar();
                break;
            case R.id.btnActualizar:
                actualizar();
                break;
            case R.id.btnEliminar:
                eliminar();
                break;
        }
    }

    private void eliminar() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_PRODUCTO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Producto Eliminado",Toast.LENGTH_LONG).show();
        campoId.setText("");
        Limpiar();
        db.close();

    }

    private void actualizar() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String [] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,campoPrecio.getText().toString());
        values.put(Utilidades.CAMPO_MARCA,campoMarca.getText().toString());

        db.update(Utilidades.TABLA_PRODUCTO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Producto Actualizado",Toast.LENGTH_LONG).show();
        campoId.setText("");
        Limpiar();
        db.close();
    }

    private void consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_PRECIO,Utilidades.CAMPO_MARCA};

        try{
            Cursor cursor =db.query(Utilidades.TABLA_PRODUCTO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();

            campoNombre.setText(cursor.getString(0));
            campoPrecio.setText(cursor.getString(1));
            campoMarca.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El producto no existe",Toast.LENGTH_LONG).show();
            Limpiar();
        }

    }
    private void Limpiar(){
        campoNombre.setText("");
        campoPrecio.setText("");
        campoMarca.setText("");
    }

}
