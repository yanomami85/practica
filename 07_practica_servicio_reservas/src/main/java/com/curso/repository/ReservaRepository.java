package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
	
	public List<Reserva> getAllByIdHotel(int idHotel);

}
