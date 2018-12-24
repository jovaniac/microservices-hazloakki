package com.hazloakki.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public class NegocioDto {

	private String idNegocio;
	private String nombre;
	private Integer idCategoria; // revisar este campo
	private String email;
	private String descripcion;
	private String telefono;
	private String domicilio;
	private Double latitud;
	private Double longitud;
	private String idCuenta;
	private String codigoPostal;
	private String delegacion;
	private String colonia;
	private String calle;
	private String numeroExterior;
	private boolean estatus;
	private String horario;
	private String responsable;
	private List<ServiciosDto> serviciosList = new ArrayList<>();
	private List<MetodoPagoDto> metodoPagoList = new ArrayList<>();
	private List<TipoTarjetaDto> tipoTarjetaList = new ArrayList<>();
	private Integer idAccion;
	private String sitioWeb;
	private List<HorarioNegocioDto> horarioNegocio = new ArrayList<>();
	private String distancia;

	public String getIdNegocio() {
		return idNegocio;
	}

	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDelegacion() {
		return delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public List<ServiciosDto> getServiciosList() {
		return serviciosList;
	}

	public void setServiciosList(List<ServiciosDto> serviciosList) {
		this.serviciosList = serviciosList;
	}

	public List<MetodoPagoDto> getMetodoPagoList() {
		return metodoPagoList;
	}

	public void setMetodoPagoList(List<MetodoPagoDto> metodoPagoList) {
		this.metodoPagoList = metodoPagoList;
	}

	public List<TipoTarjetaDto> getTipoTarjetaList() {
		return tipoTarjetaList;
	}

	public void setTipoTarjetaList(List<TipoTarjetaDto> tipoTarjetaList) {
		this.tipoTarjetaList = tipoTarjetaList;
	}

	public Integer getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public List<HorarioNegocioDto> getHorarioNegocio() {
		return horarioNegocio;
	}

	public void setHorarioNegocio(List<HorarioNegocioDto> horarioNegocio) {
		this.horarioNegocio = horarioNegocio;
	}

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	
	

}
