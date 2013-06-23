package com.manuelgon.communitypes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GestionUsuarios extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gestion_usuarios);
	}
	
	public void lanzarCrearUsuario (View view){
		Intent i = new Intent(this, NuevoUsuario.class);
		startActivity(i);
	}
	
	public void lanzaVerUsuarios(View view){
		Intent i = new Intent(this, VerUsuariosExistentes.class);
		startActivity(i);
	}
}
