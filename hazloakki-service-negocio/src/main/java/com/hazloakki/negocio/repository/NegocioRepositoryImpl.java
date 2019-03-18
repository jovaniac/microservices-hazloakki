package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.NegocioDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;

@Repository
public class NegocioRepositoryImpl extends SpringJdbcDao implements NegocioRepository {

	private String qryInsert = "INSERT INTO negocio (id_negocio,nombre,id_categoria,email,descripcion,telefono,"
			+ " domicilio,latitud,longitud,estatus,codigo_postal,delegacion,colonia,calle,"
			+ " numero_exterior,horario,responsable,id_cuenta,id_accion,sitio_web) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private String qrySelectNegocio = "select a.*,b.descripcion as nombre_categoria from negocio a, cat_categoria_negocios b where a.id_negocio = ? AND a.id_categoria=b.id_categoria" ;

	private String qrySelecNegociosByCuentaAndEstatus = "SELECT * FROM negocio WHERE id_cuenta = ? and estatus = ?";

	private String qryUpdateNegocio = "UPDATE negocio set nombre = ?, id_categoria = ?, email = ?, descripcion = ?,"
			+ " telefono = ?, domicilio = ?, latitud = ?, longitud = ?,  estatus = ?, codigo_postal = ?,"
			+ "  delegacion = ?, colonia = ?, calle = ? , numero_exterior = ?, responsable = ? WHERE ID_NEGOCIO = ?";

	private String qryDeleteNegocio = "DELETE FROM negocio WHERE ID_NEGOCIO = ?";
	private String qrySelectNegociosByAccionAndEstatus = "SELECT * FROM negocio WHERE ID_ACCION=? AND ESTATUS = ?";
	private String qryAllNegocios = "SELECT * FROM negocio WHERE ESTATUS = ?";
	
	
	private String qryNegociosCercanos="select a.*,b.distancia, c.nombre as nombre_categoria from 	\n" + 
			"			(SELECT * FROM negocio a) as a, 	\n" + 
			"			(SELECT b.id_negocio,(6371 * acos( cos( radians(?) ) * cos( radians( latitud ) ) * 		\n" + 
			"			cos( radians( longitud ) - 		radians(?) ) + 		sin( radians(?) ) * 		\n" + 
			"			sin( radians( latitud ) ))) / 10 as distancia 	from negocio b) as b, cat_categoria_negocios c\n" + 
			"			where a.id_negocio = b.id_negocio \n" + 
			"			and a.ESTATUS = ? \n" + 
			"			and a.ID_ACCION = ? \n" + 
			"			and b.distancia < ? \n" + 
			"			and a.id_categoria = c.id_categoria\n" + 
			"			order by b.distancia asc  ";
	
	@Override
	public String guardar(NegocioDto negocioDto) {

		negocioDto.setIdNegocio(generadorLlaves());

		jdbcTemplate.update(qryInsert, negocioDto.getIdNegocio(), negocioDto.getNombre(), negocioDto.getIdCategoria(),
				negocioDto.getEmail(), negocioDto.getDescripcion(), negocioDto.getTelefono(), negocioDto.getDomicilio(),
				negocioDto.getLatitud(), negocioDto.getLongitud(), negocioDto.isEstatus(), negocioDto.getCodigoPostal(),
				negocioDto.getDelegacion(), negocioDto.getColonia(), negocioDto.getCalle(),
				negocioDto.getNumeroExterior(), negocioDto.getResponsable(),
				negocioDto.getIdCuenta(), negocioDto.getIdAccion(), negocioDto.getSitioWeb());

		return negocioDto.getIdNegocio();
	}

	@Override
	public NegocioDto findById(String idNegocio) {

		try {
			return jdbcTemplate.queryForObject(qrySelectNegocio, new Object[] { idNegocio },
					BeanPropertyRowMapper.newInstance(NegocioDto.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public List<NegocioDto> findByIdCuentaAndEstatus(String idCuenta, boolean estatus) {
		return jdbcTemplate.query(qrySelecNegociosByCuentaAndEstatus, new Object[] { idCuenta, estatus },
				BeanPropertyRowMapper.newInstance(NegocioDto.class));
	}

	@Override
	public void actualizarByIdNegocio(String idNegocio, NegocioDto negocioDto) {
		jdbcTemplate.update(qryUpdateNegocio, negocioDto.getNombre(), negocioDto.getIdCategoria(),
				negocioDto.getEmail(), negocioDto.getDescripcion(), negocioDto.getTelefono(), negocioDto.getDomicilio(),
				negocioDto.getLatitud(), negocioDto.getLongitud(), negocioDto.isEstatus(), negocioDto.getCodigoPostal(),
				negocioDto.getDelegacion(), negocioDto.getColonia(), negocioDto.getCalle(),
				negocioDto.getNumeroExterior(), negocioDto.getResponsable(),
				negocioDto.getIdCuenta(), negocioDto.getIdNegocio());
	}

	@Override
	public void eliminarByIdNegocio(String idNegocio) {
		jdbcTemplate.update(qryDeleteNegocio, idNegocio);
	}

	@Override
	public List<NegocioDto> obtenerNegociosByIdAccionAndEstatus(Integer idAccion, boolean estatus) {

		return jdbcTemplate.query(qrySelectNegociosByAccionAndEstatus, new Object[] { idAccion, estatus },
				BeanPropertyRowMapper.newInstance(NegocioDto.class));
	}

	@Override
	public List<NegocioDto> findAllNegociosByEstatus(boolean estatus) {
		return jdbcTemplate.query(qryAllNegocios, new Object[] { estatus },
				BeanPropertyRowMapper.newInstance(NegocioDto.class));
	}

	@Override
	public List<NegocioDto> findAllNegociosByNearbyAndEstatus(double latitudActual, double longitudActual,
			String idAccion, double radio, boolean estatus) {
		
		 return jdbcTemplate.query(qryNegociosCercanos, new Object[] {latitudActual,longitudActual,latitudActual,estatus,Integer.parseInt(idAccion),radio},
				BeanPropertyRowMapper.newInstance(NegocioDto.class));
	}
}
