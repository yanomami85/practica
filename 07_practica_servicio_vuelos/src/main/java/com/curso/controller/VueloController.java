package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

@RestController
public class VueloController {
	
	@Autowired
	VueloService vueloService;

	@GetMapping(name = "obtenerVuelosDisponibles/{plazasDisponibles}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> getHotelesDisponibles(@PathVariable(name = "plazasDisponibles") int plazasDisponibles){
		return vueloService.getVuelosDisponibles(plazasDisponibles);
	}

	@PutMapping(name = "actualizarPlazasDisponibles/{idVuelo}/{plazasReservadas}", consumes = {MediaType.TEXT_PLAIN_VALUE})
	public void setVueloDisponibles(@PathVariable(name = "idVuelo") int idVuelo, @PathVariable(name = "plazasReservadas") int plazasReservadas){
		vueloService.setVueloDisponibles(idVuelo, plazasReservadas);
	}

}
