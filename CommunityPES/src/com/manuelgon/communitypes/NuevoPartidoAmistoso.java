package com.manuelgon.communitypes;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class NuevoPartidoAmistoso extends Activity{

	private String jugador1;
	private String jugador2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nuevo_partido_amistoso);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			String jug1 = extras.getString("jug1");
			String jug2 = extras.getString("jug2");
			
			jugador1 = jug1;
			EditText j1 = (EditText)findViewById(R.id.editTextJugador1Amistoso);
			j1.setText(jugador1);
			
			jugador2 = jug2;
			EditText j2 = (EditText)findViewById(R.id.editTextJugador2Amistoso);
			j2.setText(jugador2);
			
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void lanzarSeleccionJugadores(View view) {
		Intent i = new Intent(this, SeleccionJugadores.class);
		startActivity(i);
	}
	
	public void lanzarResultadoPartidoAmistoso(View view){
		Intent i = new Intent(this, ResultadoPartidoAmistoso.class);
		startActivity(i);
	}
	
	
	private List<String> listaUsuarios(){
		//Lista de usuarios
		List<String> lu = new ArrayList<String>();
		
		//Abrimos la base de datos 'DBUsuarios' en modo escritura
		UsuariosSQLiteHelper usdbh = new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
		SQLiteDatabase db = usdbh.getWritableDatabase();
		String[] campos = new String[] {"nombre"};
		Cursor c = db.query("Usuarios", campos, null, null, null, null, null);
		
		if(c.moveToFirst()){
			do{
				String nombre = c.getString(0);
				// Imprimo por consola los nombres de los usuarios
				System.out.println(nombre);
				lu.add(nombre);
			}while(c.moveToNext());
		}
		return lu;
	}
	
}
