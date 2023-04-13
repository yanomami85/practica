package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> getHotelesDisponibles() {
		return hotelRepository.getAllByDisponible(true);
	}

	@Override
	public Hotel getInfoHotel(String nombre) {
		return hotelRepository.getByNombre(nombre);
	}

}
