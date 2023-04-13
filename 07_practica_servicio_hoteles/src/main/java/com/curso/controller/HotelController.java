package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	HotelService hotelService;

	@GetMapping(name = "getHotelesDisponibles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> getHotelesDisponibles(){
		return hotelService.getHotelesDisponibles();
	}
	
	@GetMapping(name = "getInfoHotel/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotel getInfoHotel(@PathVariable(name = "nombre") String nombre) {
		return hotelService.getInfoHotel(nombre);
	}
	
}
