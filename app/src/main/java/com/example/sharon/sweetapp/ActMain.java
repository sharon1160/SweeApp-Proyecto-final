package com.example.sharon.sweetapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.sharon.sweetapp.BaseDatos.DatosOpenHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class ActMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_productos",null,1);
    }
    public void onClick(View view){
        Intent miIntent=null;
        switch(view.getId()){
            case R.id.btnAgregar:
                miIntent=new Intent(ActMain.this,ActNuevoProducto.class);
                break;
            case R.id.btnConsultar:
                miIntent=new Intent(ActMain.this,ActConsultar.class);
                break;
        }
        if(miIntent!=null){
            startActivity(miIntent);
        }
    }
}
























