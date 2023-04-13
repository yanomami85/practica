package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;

public class VueloServiceImpl implements VueloService {
	
	@Autowired
	VueloRepository vueloRepository;

	@Override
	public List<Vuelo> getVuelosDisponibles(int plazasDisponibles) {
		return vueloRepository.getAllByPlazasDisponiblesGreaterThanOrEqual(plazasDisponibles);
	}

	@Override
	public void setVueloDisponibles(int idVuelo, int plazasReservadas) {
		Vuelo vuelo = vueloRepository.findById(idVuelo).orElse(null);
		if (vuelo != null) {
			vuelo.setPlazasDisponibles(vuelo.getPlazasDisponibles() - plazasReservadas);
			vueloRepository.save(vuelo);
		}
	}

}
