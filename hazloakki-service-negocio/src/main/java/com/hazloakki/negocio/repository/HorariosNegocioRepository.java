package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.HorarioNegocioDto;

public interface HorariosNegocioRepository {

	/**
	 * Crear horario de un negocio por dia
	 * @param idNegocio
	 * @param idDia
	 * @param horarioInicial
	 * @param horarioFinal
	 * @param estatus
	 */
	void save(String idNegocio, Integer idDia, String horarioInicial, String horarioFinal, boolean estatus);

	/**
	 * @param idNegocio
	 * @param estatus
	 * @return
	 */
	List<HorarioNegocioDto> findHorarioNegocioByEstatus(String idNegocio, boolean estatus);

	void delete(String idNegocio);

	HorarioNegocioDto findNegocioAbierto(String idNegocio, String horaActual, Integer idDia);
	
}
