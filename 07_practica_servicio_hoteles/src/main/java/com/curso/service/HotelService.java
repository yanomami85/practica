package com.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Hotel;

@Service
public interface HotelService {
	
	public List<Hotel> getHotelesDisponibles();
	
	public Hotel getInfoHotel(String nombre);

}
