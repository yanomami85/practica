package com.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Vuelo;

@Service
public interface VueloService {
	
	public List<Vuelo> getVuelosDisponibles(int plazasDisponibles);
	
	public void setVueloDisponibles(int idVuelo, int plazasReservadas);

}
