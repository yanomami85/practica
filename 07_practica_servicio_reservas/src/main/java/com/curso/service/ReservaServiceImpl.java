package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.curso.dto.ObtenerReservasDTO;
import com.curso.dto.RegistrarReservaDTO;
import com.curso.model.Hotel;
import com.curso.model.Reserva;
import com.curso.repository.ReservaRepository;

public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	RestTemplate restTemplate;

	String urlHoteles = "http://servicio-hoteles/";
	String urlVuelos = "http://servicio-vuelos/";

	@Override
	public void registrarReserva(RegistrarReservaDTO reservaDto) {
		Reserva reserva = new Reserva(reservaDto.getNombreCliente(), reservaDto.getDni(), reservaDto.getIdHotel(), reservaDto.getIdVuelo());
		reservaRepository.save(reserva);
		restTemplate.put(urlVuelos + "actualizarPlazasDisponibles/{idVuelo}/{plazasDisponibles}", null, reservaDto.getIdVuelo(), reservaDto.getPlazasReservadas());
	}

	@Override
	public List<ObtenerReservasDTO> obtenerReservasExistentes(String nombreHotel) {
		Hotel hotel = restTemplate.getForObject(urlHoteles + "getInfoHotel/{nombreHotel}", Hotel.class, nombreHotel);
		List<Reserva> listaReservas = reservaRepository.getAllByIdHotel(hotel.getIdHotel());
		List<ObtenerReservasDTO> listaReservasResponse = new ArrayList<ObtenerReservasDTO>();
		listaReservas.forEach(reserva -> {
			ObtenerReservasDTO reservaDto = new ObtenerReservasDTO();
			reservaDto.setNombreCliente(reserva.getNombreCliente());
			reservaDto.setDni(reserva.getDni());
			reservaDto.setIdVuelo(reserva.getIdVuelo());
			listaReservasResponse.add(reservaDto);
		});
		return listaReservasResponse;
	}

}
