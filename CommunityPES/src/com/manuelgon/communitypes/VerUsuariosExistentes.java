package com.manuelgon.communitypes;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VerUsuariosExistentes extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ver_usuarios_existentes);
		AlmacenPuntuacionesSQLite dbHelper = new AlmacenPuntuacionesSQLite(VerUsuariosExistentes.this);
		setListAdapter(new MiAdaptador(this, dbHelper.obtenerNombreUsuarios()));
	}
	
	public void verusuarios (View view){
	}
}
