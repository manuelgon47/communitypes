package com.manuelgon.communitypes;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class VerUsuariosExistentes extends ListActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ver_usuarios_existentes);
//		IAlmacenarPuntuaciones dbHelper = new AlmacenPuntuacionesSQLite(VerUsuariosExistentes.this);
		IAlmacenarPuntuaciones dbHelper = CommunityPES.baseDatos;
		setListAdapter(new MiAdaptador(this, dbHelper.obtenerNombreUsuarios()));
	}
	
	public void verusuarios (View view){
	}
	
	@Override
	protected void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);
		Object o = getListAdapter().getItem(position);
		Toast.makeText(this, "Selección: " + Integer.toString(position)	+ " - " + o.toString(), Toast.LENGTH_LONG).show();
		String nombre = o.toString();
		Intent i = new Intent(this, EstadisticasUsuario.class);
		i.putExtra("usuario", nombre);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);

	}
}
