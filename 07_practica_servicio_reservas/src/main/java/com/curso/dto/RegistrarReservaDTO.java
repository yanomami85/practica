package com.curso.dto;

public class RegistrarReservaDTO {
	
	private String nombreCliente;
	private String dni;
	private int idHotel;
	private int idVuelo;
	private int plazasReservadas;
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getIdHotel() {
		return idHotel;
	}
	
	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}
	
	public int getIdVuelo() {
		return idVuelo;
	}
	
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	
	public int getPlazasReservadas() {
		return plazasReservadas;
	}
	
	public void setPlazasReservadas(int plazasReservadas) {
		this.plazasReservadas = plazasReservadas;
	}

}
