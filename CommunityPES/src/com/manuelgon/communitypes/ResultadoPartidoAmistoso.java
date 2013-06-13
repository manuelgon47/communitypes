package com.manuelgon.communitypes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResultadoPartidoAmistoso extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resultado_partido_amistoso);
	}
	
	public void lanzarMenuPrincipal (View view){
		Intent i = new Intent(this, CommunityPES.class);
		startActivity(i);
	}
	
}
