package com.manuelgon.communitypes;

import java.util.Vector;

import android.content.ContentValues;
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
	public void guardarPuntuaciones(String jugador, Integer golesFavor,	Integer golesContra, Boolean ganado) {
		// Saco lo que hay ahora mismo en la base de datos de forma más eficiente
		Usuario jug = obtenerUsuario(jugador);
		Integer jugadosJug = jug.getJugados();
		Integer gfJug =jug.getGolesFavor();
		Integer gcJug = jug.getGolesContra();
		Integer ganadosJug = jug.getGanados();
		Integer perdidosJug = jug.getPerdidos();
		if(ganado){
			ganadosJug +=1;
		}else{
			perdidosJug +=1;
		}
		SQLiteDatabase db = getWritableDatabase();
		
		//Meto los nuevos valores en un contentValues
		ContentValues valoresJug = new ContentValues();
		valoresJug.put("golesFavor", gfJug+golesFavor);
		valoresJug.put("golesContra", gcJug+golesContra);
		valoresJug.put("jugados", jugadosJug+1);
		valoresJug.put("ganados", ganadosJug);
		valoresJug.put("perdidos", perdidosJug);
		
		//Actualizo en BD metiendo el contentValues
		db.update("Amistosos", valoresJug, "nombreUsuario='"+jugador+"'", null);
		
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

	@Override
	public void partidoAmistoso(String jugadorUno, String jugadorDos, String ganador, Integer resjuguno, Integer resjugdos, Boolean empate) {
		if(empate){
			empate(jugadorUno, jugadorDos, resjuguno, resjugdos);
		}else{
			if(ganador.equals(jugadorUno)){
				guardarPuntuaciones(jugadorUno, resjuguno, resjugdos, true);
				guardarPuntuaciones(jugadorDos, resjugdos, resjuguno, false);
			}else{
				guardarPuntuaciones(jugadorDos, resjugdos, resjuguno, true);
				guardarPuntuaciones(jugadorUno, resjuguno, resjugdos, false);
			}
		}
		
	}
	public Integer obtenerNumeroPartidosJugados(String nombreJugador){
		Integer ret = 0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT jugados FROM Amistosos WHERE nombreUsuario='"+nombreJugador+"'", null);
		cursor.moveToNext();
		ret = cursor.getInt(0);
		return ret;
	}

	@Override
	public void empate(String jugadorUno, String jugadorDos, Integer resjuguno,	Integer resjugdos) {
		// Saco lo que hay ahora mismo en la base de datos
//		Integer jugadosJugUno = obtenerNumeroPartidosJugados(jugadorUno);
//		Integer jugadosJugDos = obtenerNumeroPartidosJugados(jugadorDos);
//		Integer empatadosJugUno = obtenerNumeroPartidosEmpatados(jugadorUno);
//		Integer empatadosJugDos = obtenerNumeroPartidosEmpatados(jugadorDos);
//		Integer gfJugUno = obtenerNumeroGolesFavor(jugadorUno);
//		Integer gfJugDos = obtenerNumeroGolesFavor(jugadorDos);
//		Integer gcJugUno = obtenerNumeroGolesContra(jugadorUno);
//		Integer gcJugDos = obtenerNumeroGolesContra(jugadorDos);
		
		// Saco lo que hay ahora mismo en la base de datos de forma más eficiente
		Usuario jug1 = obtenerUsuario(jugadorUno);
		Usuario jug2 = obtenerUsuario(jugadorDos);
		Integer jugadosJugUno = jug1.getJugados();
		Integer jugadosJugDos = jug2.getJugados();
		Integer empatadosJugUno = jug1.getEmpatados();
		Integer empatadosJugDos = jug2.getEmpatados();
		Integer gfJugUno =jug1.getGolesFavor();
		Integer gfJugDos = jug2.getGolesFavor();
		Integer gcJugUno = jug1.getGolesContra();
		Integer gcJugDos = jug2.getGolesContra();
		SQLiteDatabase db = getWritableDatabase();
		System.out.println("ESTO ES UNA PRUEBA 1 ----------------------------------------------------");
		
		//JUGADOR 1
		
		//Meto los nuevos valores en un contentValues
		ContentValues valoresJugUno = new ContentValues();
		valoresJugUno.put("golesFavor", gfJugUno+resjuguno);
		valoresJugUno.put("golesContra", gcJugUno+resjugdos);
		valoresJugUno.put("jugados", jugadosJugUno+1);
		valoresJugUno.put("empatados", empatadosJugUno+1);
		
		//Actualizo en BD metiendo el contentValues
		db.update("Amistosos", valoresJugUno, "nombreUsuario='"+jugadorUno+"'", null);
		System.out.println("FIN DE LA PRUEBA 1 ----------------------------------------------------");
		
		
		//JUGADOR 2
		System.out.println("ESTO ES UNA PRUEBA 2 ----------------------------------------------------");
		//Meto los nuevos valores en un contentValues
		ContentValues valoresJugDos = new ContentValues();
		valoresJugDos.put("golesFavor", gfJugDos+resjugdos);
		valoresJugDos.put("golesContra", gcJugDos+resjuguno);
		valoresJugDos.put("jugados", jugadosJugDos+1);
		valoresJugDos.put("empatados", empatadosJugDos+1);
		
		//Actualizo en BD metiendo el contentValues
		db.update("Amistosos", valoresJugDos, "nombreUsuario='"+jugadorDos+"'", null);
		System.out.println("FIN DE LA PRUEBA 2 ----------------------------------------------------");
		
		
	}

	@Override
	public Integer obtenerNumeroPartidosGanados(String nombreJugador) {
		Integer ret = 0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT ganados FROM Amistosos WHERE nombreUsuario='"+nombreJugador+"'", null);
		cursor.moveToNext();
		ret = cursor.getInt(0);
		return ret;
	}

	@Override
	public Integer obtenerNumeroPartidosPerdidos(String nombreJugador) {
		Integer ret = 0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT perdidos FROM Amistosos WHERE nombreUsuario='"+nombreJugador+"'", null);
		cursor.moveToNext();
		ret = cursor.getInt(0);
		return ret;
	}

	@Override
	public Integer obtenerNumeroPartidosEmpatados(String nombreJugador) {
		Integer ret = 0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT empatados FROM Amistosos WHERE nombreUsuario='"+nombreJugador+"'", null);
		cursor.moveToNext();
		ret = cursor.getInt(0);
		return ret;
	}

	@Override
	public Integer obtenerNumeroGolesFavor(String nombreJugador) {
		Integer ret = 0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT golesFavor FROM Amistosos WHERE nombreUsuario='"+nombreJugador+"'", null);
		cursor.moveToNext();
		ret = cursor.getInt(0);
		return ret;
	}

	@Override
	public Integer obtenerNumeroGolesContra(String nombreJugador) {
		Integer ret = 0;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT golesContra FROM Amistosos WHERE nombreUsuario='"+nombreJugador+"'", null);
		cursor.moveToNext();
		ret = cursor.getInt(0);
		return ret;
	}

	@Override
	public Boolean exiteEnBD(String usuario) {
		Boolean ret = false;
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT nombreUsuario FROM Amistosos WHERE nombreUsuario='"+usuario+"'", null);
		cursor.moveToNext();
		if(cursor.getString(0) != null)
			ret = true;
		return ret;
	}


}
