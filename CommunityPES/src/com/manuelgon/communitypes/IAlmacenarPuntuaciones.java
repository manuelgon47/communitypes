package com.manuelgon.communitypes;

import java.util.List;
import java.util.Vector;

public interface IAlmacenarPuntuaciones {
	
	void registraUsuario(String jugador);
	void guardarPuntuaciones(String jugador, Integer golesFavor, Integer golesContra, Boolean ganado);
	Usuario obtenerUsuario(String usuario);
	List<Usuario> obtenerUsuarios();
	Vector<String> obtenerNombreUsuarios();
}
