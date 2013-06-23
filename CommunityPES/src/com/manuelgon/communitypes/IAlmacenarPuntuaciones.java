package com.manuelgon.communitypes;

import java.util.List;
import java.util.Vector;

public interface IAlmacenarPuntuaciones {
	
	void registraUsuario(String jugador);
	void guardarPuntuaciones(String jugador, Integer golesFavor, Integer golesContra, Boolean ganado);
	Usuario obtenerUsuario(String usuario);
	List<Usuario> obtenerUsuarios();
	Vector<String> obtenerNombreUsuarios();
	void partidoAmistoso(String jugadorUno, String jugadorDos, String ganador, Integer resjuguno, Integer resjugdos, Boolean empate);
	void empate (String jugadorUno, String jugadorDos, Integer resjuguno, Integer resjugdos);
	Integer obtenerNumeroPartidosJugados(String nombreJugador);
}
