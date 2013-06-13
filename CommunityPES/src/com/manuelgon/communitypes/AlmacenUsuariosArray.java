package com.manuelgon.communitypes;

import java.util.Vector;

public class AlmacenUsuariosArray {
	private Vector<String> usuarios;

	public AlmacenUsuariosArray() {
		usuarios = new Vector<String>();
		usuarios.add("Manuel");
		usuarios.add("Victor");
		usuarios.add("Alberto");
		usuarios.add("Juanmi");

	}

//	public void guardarPuntuacion(int puntos, String nombre, long fecha) {
//		puntuaciones.add(0, puntos + " "+ nombre);
//	}

	public Vector<String> listaPuntuaciones() {

		return usuarios;
	}
}
