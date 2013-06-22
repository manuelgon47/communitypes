package com.manuelgon.communitypes;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SeleccionJugadores extends ListActivity {

	private int cont = 0;
	private String jug1;
	private String jug2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seleccion_jugadores);
		setListAdapter(new MiAdaptador(this, CommunityPES.almacenUsuarios.listaPuntuaciones()));
	}
	
	@Override
	protected void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);
		Object o = getListAdapter().getItem(position);
		Toast.makeText(this, "Selección: " + Integer.toString(position)	+ " - " + o.toString(), Toast.LENGTH_LONG).show();
		String nombre = o.toString();
		Intent i = new Intent(this, NuevoPartidoAmistoso.class);
		if(cont == 0){
			jug1 = nombre;
			cont++;
		}
		else{
			jug2 = nombre;
			i.putExtra("jug1", jug1);
			i.putExtra("jug2", jug2);
			startActivity(i);
		}

	}

}
