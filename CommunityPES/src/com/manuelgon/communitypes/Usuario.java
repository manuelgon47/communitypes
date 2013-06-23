package com.manuelgon.communitypes;

public class Usuario {
	private String nombreUsuario;
	private Integer golesFavor;
	private Integer golesContra;
	private Integer jugados;
	private Integer ganados;
	private Integer perdidos;
	private Integer empatados;
	private Integer ganadosConsecutivos;
	private Integer perdidosConsecutivos;
	
	
	public Usuario() {
		nombreUsuario = "";
		golesFavor = 0;
		golesContra = 0;
		jugados = 0;
		ganados = 0;
		perdidos = 0;
		empatados = 0;
		ganadosConsecutivos = 0;
		perdidosConsecutivos = 0;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public Integer getGolesFavor() {
		return golesFavor;
	}


	public void setGolesFavor(Integer golesFavor) {
		this.golesFavor = golesFavor;
	}


	public Integer getGolesContra() {
		return golesContra;
	}


	public void setGolesContra(Integer golesContra) {
		this.golesContra = golesContra;
	}


	public Integer getJugados() {
		return jugados;
	}


	public void setJugados(Integer jugados) {
		this.jugados = jugados;
	}


	public Integer getGanados() {
		return ganados;
	}


	public void setGanados(Integer ganados) {
		this.ganados = ganados;
	}


	public Integer getPerdidos() {
		return perdidos;
	}


	public void setPerdidos(Integer perdidos) {
		this.perdidos = perdidos;
	}


	public Integer getEmpatados() {
		return empatados;
	}


	public void setEmpatados(Integer empatados) {
		this.empatados = empatados;
	}


	public Integer getGanadosConsecutivos() {
		return ganadosConsecutivos;
	}


	public void setGanadosConsecutivos(Integer ganadosConsecutivos) {
		this.ganadosConsecutivos = ganadosConsecutivos;
	}


	public Integer getPerdidosConsecutivos() {
		return perdidosConsecutivos;
	}


	public void setPerdidosConsecutivos(Integer perdidosConsecutivos) {
		this.perdidosConsecutivos = perdidosConsecutivos;
	}
	
	
	
}
