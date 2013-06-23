package com.manuelgon.communitypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlmacenPuntuacionesSQLite extends SQLiteOpenHelper implements IAlmacenarPuntuaciones{

	public AlmacenPuntuacionesSQLite(Context context) {
		super(context, "communitypesDB	", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("Voy a crear la base de datos -------------------------------");
		db.execSQL("CREATE TABLE Amistosos("+
				"nombreUsuario TEXT PRIMARY KEY, "+
				"golesFavor INTEGER, "+
				"golesContra INTEGER, "+
				"jugados INTEGER, "+
				"ganados INTEGER, "+
				"perdidos INTEGER, "+
				"empatados INTEGER, "+
				"ganadosConsecutivos INTEGER, "+
				"perdidosConsecutivos INTEGER)");
		System.out.println("Ya he creado la base de datos ************************************************");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void registraUsuario(String jugador) {
		System.out.println("Voy a registrar un usuario, el usuario "+jugador+" ----------------------------------------------------");
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("INSERT INTO Amistosos VALUES ( '"+
				jugador+"', "+
				0+", "+
				0+", "+
				0+", "+
				0+", "+
				0+", "+
				0+", "+
				0+", "+
				0+")");
		System.out.println("Ya he registrado al usuario -----------------------------------------------------------------------------");
		
	}

	@Override
	public void guardarPuntuaciones(String jugador, Integer golesFavor,
			Integer golesContra, Boolean ganado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario obtenerUsuario(String usuario) {
		Usuario u = new Usuario();
		//List<String> aux = new ArrayList<String>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM Amistosos WHERE nombreUsuario='"+usuario+"'", null);
		while (cursor.moveToNext()){
			u.setNombreUsuario(cursor.getString(0));
			u.setGolesFavor(cursor.getInt(1));
			u.setGolesContra(cursor.getInt(2));
			u.setJugados(cursor.getInt(3));
			u.setGanados(cursor.getInt(4));
			u.setPerdidos(cursor.getInt(5));
			u.setEmpatados(cursor.getInt(6));
			u.setGanadosConsecutivos(cursor.getInt(7));
			u.setPerdidosConsecutivos(cursor.getInt(8));
		}
		cursor.close();
		return u;
	}
	
	@Override
	public Vector<Usuario> obtenerUsuarios() {
		Vector<Usuario> aux = new Vector<Usuario>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM Amistosos", null);
		Usuario u;
		while (cursor.moveToNext()){
			u = new Usuario();
			u.setNombreUsuario(cursor.getString(1));
			u.setGolesFavor(cursor.getInt(2));
			u.setGolesContra(cursor.getInt(3));
			u.setJugados(cursor.getInt(4));
			u.setGanados(cursor.getInt(5));
			u.setPerdidos(cursor.getInt(6));
			u.setEmpatados(cursor.getInt(7));
			u.setGanadosConsecutivos(cursor.getInt(8));
			u.setPerdidosConsecutivos(cursor.getInt(9));
			aux.add(u);
		}
		cursor.close();
		return aux;
	}
	
	@Override
	public Vector<String> obtenerNombreUsuarios() {
		System.out.println("Voy a obtener a los usuarios de la base de datos ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Vector<String> aux = new Vector<String>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM Amistosos", null);
		while (cursor.moveToNext()){
			aux.add(cursor.getString(0));
		}
		cursor.close();
		return aux;
	}


}
