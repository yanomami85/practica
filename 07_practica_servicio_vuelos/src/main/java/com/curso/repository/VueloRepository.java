package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
	
	public List<Vuelo> getAllByPlazasDisponiblesGreaterThanOrEqual(int plazasDisponibles);

}
