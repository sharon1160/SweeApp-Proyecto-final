package com.example.sharon.sweetapp.BaseDatos;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper{


    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(_ID integer primary key autoincrement, " +
                "Nombre text, Usuario text, Password text, Edad text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //metodo  que permite abrir base de datos
    public void abrir(){
        this.getWritableDatabase();
    }
    //metodo  que permite cerrar base de datos
    public void cerrar(){
        this.close();
    }

    //metodo que permite insertar registro en la tabla usuarios
    public void insertarReg(String nom,String usu,String pas,String ed){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Usuario",usu);
        valores.put("Password",pas);
        valores.put("Edad",ed);
        this.getWritableDatabase().insert("usuarios",null,valores);

    }

    //metodo quepermitvalidar si el usuario existe
    public Cursor ConsultarUsuPas(String usu,String pas)throws SQLException{
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","Usuario","Password","Edad"},"Usuario like '"+usu+"' and Password like '"+pas+"'",null,null,null,null);

        return mcursor;
    }
}










