package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.HorarioNegocioDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;

@Repository
public class HorariosNegocioRepositoryImpl extends SpringJdbcDao implements HorariosNegocioRepository {

	private String qryGuardarHorario = "INSERT INTO negocio_horario (id_negocio,id_dia,horario_inicial,horario_final,estatus) "
			+ "VALUES(?,?,?,?,?)";

	private String qrySelectByNegocioAndEstatus = "select * from cat_dias b, negocio_horario c\n" + 
			"where c.id_dia = b.id_dia\n" + 
			"and c.id_negocio = ?\n" + 
			"and c.estatus = ?"
			+ " order by b.id_dia asc";
	
	private String qryDeleteNegocios = "DELETE FROM negocio_horario WHERE ID_NEGOCIO = ?";

	private String qrySelectNegociosAbiertos = "select * from negocio_horario a " + 
			"where a.id_negocio = ? and a.id_dia = ? " + 
			"and (TO_TIMESTAMP(?, 'HH24:MI:SS')::TIME >= a.horario_inicial OR " + 
			"TO_TIMESTAMP(?, 'HH24:MI:SS')::TIME <= a.horario_final) ";
	
	private String qrySelectHorarioDiaActual="select * from negocio a, cat_dias b, negocio_horario c\n" + 
			"where a.id_negocio = c.id_negocio\n" + 
			"and c.id_dia = b.id_dia\n" + 
			"and b.id_dia = ?";

	@Override
	public List<HorarioNegocioDto> findHorarioNegocioByEstatus(String idNegocio, boolean estatus) {

		return jdbcTemplate.query(qrySelectByNegocioAndEstatus, new Object[] { idNegocio, estatus },
				BeanPropertyRowMapper.newInstance(HorarioNegocioDto.class));
	}

	@Override
	public void save(String idNegocio, Integer idDia, String horarioInicial, String horarioFinal, boolean estatus) {
		jdbcTemplate.update(qryGuardarHorario, idNegocio, idDia, horarioInicial, horarioFinal, estatus);
	}

	@Override
	public void delete(String idNegocio) {
		jdbcTemplate.update(qryDeleteNegocios, idNegocio);
	}

	@Override
	public HorarioNegocioDto findNegocioAbierto(String idNegocio, String horaActual, Integer idDia) {
		try {

			return jdbcTemplate.queryForObject(qrySelectNegociosAbiertos,
					new Object[] { idNegocio, idDia, horaActual, horaActual },
					BeanPropertyRowMapper.newInstance(HorarioNegocioDto.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
