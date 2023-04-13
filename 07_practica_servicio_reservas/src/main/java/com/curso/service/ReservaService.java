package com.curso.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.dto.ObtenerReservasDTO;
import com.curso.dto.RegistrarReservaDTO;

@Service
public interface ReservaService {
	
	public void registrarReserva(RegistrarReservaDTO reservaDto);

	public List<ObtenerReservasDTO> obtenerReservasExistentes(String nombreHotel);

}
