package com.manuelgon.communitypes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NuevoUsuario extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nuevo_usuario);
	}
	
	public void crearUsuario (View view){
		EditText nombre = (EditText) findViewById(R.id.introduceNombreUsuario);
//		System.out.println("Nombre de usuario: "+nombre.getText().toString()+"  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		AlmacenPuntuacionesSQLite dbHelper = new AlmacenPuntuacionesSQLite(NuevoUsuario.this);
		dbHelper.registraUsuario(nombre.getText().toString());
		
		
	}
}
