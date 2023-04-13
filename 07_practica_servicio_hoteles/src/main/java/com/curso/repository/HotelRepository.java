package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
	public List<Hotel> getAllByDisponible(boolean disponible);
	
	public Hotel getByNombre(String nombre);

}
