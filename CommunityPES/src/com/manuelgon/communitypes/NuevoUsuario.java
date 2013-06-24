package com.manuelgon.communitypes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoUsuario extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nuevo_usuario);
	}
	
	public void crearUsuario (View view){
		EditText nombre = (EditText) findViewById(R.id.introduceNombreUsuario);
		
		//Compruebo si el usuario ya existe en la BD
		Boolean existe = CommunityPES.baseDatos.exiteEnBD(nombre.getText().toString());
		if(existe){
			Toast.makeText(this, R.string.textoAlerta, Toast.LENGTH_LONG).show();
		}else{
			CommunityPES.baseDatos.registraUsuario(nombre.getText().toString());
			Intent i = new Intent(this, GestionUsuarios.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}		
				
	}
	
	
	public void onBackPressed(){
		Intent i = new Intent(this, GestionUsuarios.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
	}
}
