package com.manuelgon.communitypes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResultadoPartidoAmistoso extends Activity{

	private String jugador1 = "";
	private String jugador2 = "";
	private int resJug1 = 0;
	private int resjug2 = 0;
	private String ganador = "";
	private Boolean empate = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado_partido_amistoso);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			jugador1 = extras.getString("jug1");
			jugador2 = extras.getString("jug2");
			TextView juga1 = (TextView)findViewById(R.id.juga1);
			juga1.setText(jugador1);
			TextView juga2 = (TextView)findViewById(R.id.juga2);
			juga2.setText(jugador2);
		}else{
			Toast.makeText(this, "Se ha producido un error al capturar los datos extras de los jugadores. Lo lamentamos.", Toast.LENGTH_LONG).show();
		}
	}
	
	public void lanzarMenuPrincipal (View view){
		EditText resjUno = (EditText)findViewById(R.id.resultadoJugador1);
		EditText resjDos = (EditText)findViewById(R.id.resultadoJugador2);
		String auxUno = resjUno.getText().toString();
		String auxDos = resjDos.getText().toString();
//		System.out.print("Resultado: "+auxUno);
//		System.out.println(" - "+auxDos);
		Integer rjuno = Integer.parseInt(auxUno);
		Integer rjdos = Integer.parseInt(auxDos);
		if(rjuno == rjdos){
			empate=true;
		}else if(rjuno > rjdos){
			ganador = jugador1;
		}else{
			ganador = jugador2;
		}
		
		Intent i = new Intent(this, CommunityPES.class);
		startActivity(i);
	}
	
}
