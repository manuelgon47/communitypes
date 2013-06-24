package com.manuelgon.communitypes;

import android.app.Activity;
import android.content.Intent;
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
		System.out.println("Voy a ir a SeleccionJugadores");
		Intent i = new Intent(this, SeleccionJugadoresDos.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	public void lanzarResultadoPartidoAmistoso(View view){
		Intent i = new Intent(this, ResultadoPartidoAmistoso.class);
		i.putExtra("jug1", jugador1);
		i.putExtra("jug2", jugador2);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	
	public void onBackPressed(){
		Intent i = new Intent(this, CommunityPES.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
}
