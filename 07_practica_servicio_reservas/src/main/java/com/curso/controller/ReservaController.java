package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.dto.ObtenerReservasDTO;
import com.curso.dto.RegistrarReservaDTO;
import com.curso.service.ReservaService;

@RestController
public class ReservaController {
	
	@Autowired
	ReservaService reservaService;
	
	@PostMapping(name = "registrarReserva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void registrarReserva(@RequestBody RegistrarReservaDTO registrarReservaDto) {
		reservaService.registrarReserva(registrarReservaDto);
	}
	
	@GetMapping(name = "obtenerReservasExistentes/{nombreHotel}", consumes = MediaType.TEXT_PLAIN_VALUE)
	public List<ObtenerReservasDTO> obtenerReservasExistentes(@PathVariable(name = "nombreHotel") String nombreHotel){
		return reservaService.obtenerReservasExistentes(nombreHotel);
	}

}
