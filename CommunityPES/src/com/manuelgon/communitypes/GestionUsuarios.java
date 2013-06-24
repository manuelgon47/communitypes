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
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	public void lanzaVerUsuarios(View view){
		Intent i = new Intent(this, VerUsuariosExistentes.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
	
	public void onBackPressed(){
		Intent i = new Intent(this, CommunityPES.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
}
