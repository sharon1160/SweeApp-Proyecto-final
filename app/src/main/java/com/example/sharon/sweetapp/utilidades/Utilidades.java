package com.example.sharon.sweetapp.utilidades;

public class Utilidades {

    public static final String TABLA_PRODUCTO="producto";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_MARCA="marca";



    public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE " +
            ""+TABLA_PRODUCTO+" ("+CAMPO_ID+" "+
            "INTEGER,"+CAMPO_NOMBRE+" TEXT,"+CAMPO_PRECIO+" TEXT,"+CAMPO_MARCA+" TEXT)";

}
