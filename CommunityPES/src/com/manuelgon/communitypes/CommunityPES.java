package com.manuelgon.communitypes;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class CommunityPES extends Activity {

	public static AlmacenUsuariosArray almacenUsuarios = new AlmacenUsuariosArray();
	public static IAlmacenarPuntuaciones baseDatos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		baseDatos = new AlmacenPuntuacionesSQLite(this);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void lanzarNuevoPartidoAmistoso(View view) {
		Intent i = new Intent(this, NuevoPartidoAmistoso.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	
	public void lanzarGestionDeUsuarios(View view) {
		Intent i = new Intent(this, GestionUsuarios.class);
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
