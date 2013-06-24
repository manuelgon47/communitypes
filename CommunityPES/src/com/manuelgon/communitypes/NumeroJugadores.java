package com.manuelgon.communitypes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class NumeroJugadores extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numero_jugadores);
	}
	
	public void aceptarNumeroJugadores(View view) {
		Intent i = new Intent(this, SeleccionJugadoresDos.class);
		TextView numeroJugadores = (TextView) findViewById(R.id.numeroJugadores);
		i.putExtra("numJugadores", numeroJugadores.toString());
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
