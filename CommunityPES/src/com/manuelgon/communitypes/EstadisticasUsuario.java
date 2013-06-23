package com.manuelgon.communitypes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class EstadisticasUsuario extends Activity{

	private String usuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.estadisticas_usuario);
		Bundle extras = getIntent().getExtras();
		if(extras != null){
			usuario = extras.getString("usuario");
			
			//Compruebo que lo he capturado bien
			System.out.println("Usuario capturado del bundle: "+usuario);
			
			//Llamo a la clase de la base de datos para llamar al método que se encarga de sacar al usuario de la BD
			IAlmacenarPuntuaciones almacenPuntuaciones = new AlmacenPuntuacionesSQLite(this);
			//Capturo usuario
			Usuario u = almacenPuntuaciones.obtenerUsuario(usuario);
			
			//Compruebo que se ha creado correctamente el usuario:
			System.out.println("Usuario: "+u.getNombreUsuario());
			
			//Cambio cada TextView del layout para meterle el atributo que corresponde del usuario que he creado
			//anteriormente a partir de los datos de la base de datos.			
			
			//Nombre de usuario
			TextView nu = (TextView)findViewById(R.id.estUsuario);
			nu.setText(u.getNombreUsuario());
			
			//String auxiliar que usare siempre la misma para ahorrar memoria
			String aux;
			
			//Goles a Favor
			TextView gf = (TextView)findViewById(R.id.estGF);
			aux = u.getGolesFavor().toString();
			gf.setText(aux);
			
			//Goles en contara
			TextView gc = (TextView)findViewById(R.id.estGC);
			aux = u.getGolesContra().toString();
			gc.setText(aux);
			
			//Partidos jugados
			TextView jug = (TextView)findViewById(R.id.estJugados);
			aux = u.getJugados().toString();
			jug.setText(aux);
			
			//Partidos Ganados
			TextView gan = (TextView)findViewById(R.id.estGanados);
			aux = u.getGanados().toString();
			gan.setText(aux);
			
			//Partidos Perdidos
			TextView per = (TextView)findViewById(R.id.estPerdidos);
			aux = u.getPerdidos().toString();
			per.setText(aux);
			
			//Partidos empatados
			TextView emp = (TextView)findViewById(R.id.estEmpatados);
			aux = u.getEmpatados().toString();
			emp.setText(aux);
			
		}else{
			System.out.println("Se ha producico un error en la clase VerUsuariosExistentes al capturar lo extras del Bundle");
			Toast.makeText(this, "Se ha producido un error. Lo lamentamos.", Toast.LENGTH_LONG).show();
		}
	}
}
