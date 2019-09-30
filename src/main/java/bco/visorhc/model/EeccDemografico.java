package bco.visorhc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the EECC_DEMOGRAFICO database table.
 * 
 */
@Entity
@Table(name="EECC_DEMOGRAFICO")
public class EeccDemografico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=8)
	private String abreviatura;

	@Column(length=50)
	private String correo;

	@Column(name="DIR_ADICIONAL", length=70)
	private String dirAdicional;

	@Column(length=70)
	private String direccion;

	@Column(length=17)
	private String distrito;

	@Column(name="ENV_EECCCORREO", length=1)
	private String envEecccorreo;

	@Column(name="EST_CIVIL", length=1)
	private String estCivil;

	@Column(name="FEC_NACIMIENTO", length=10)
	private String fecNacimiento;

	@Column(name="ID_CENTROALTA", precision=4)
	private BigDecimal idCentroalta;

	@Column(name="ID_ENTIDAD", precision=4)
	private BigDecimal idEntidad;

	@Column(name="ID_FECVENCIMIENTO", length=10)
	private String idFecvencimiento;

	@Column(name="ID_NROCUENTA", length=16)
	private String idNrocuenta;
	
	@Id
	@Column(name="ID_NRODOCUMENTO", length=12)
	private String idNrodocumento;

	@Column(length=50)
	private String nombres;

	@Column(name="NUM_TELEFONOCELULAR", length=20)
	private String numTelefonocelular;

	@Column(name="NUM_TELEFONOFIJO", length=20)
	private String numTelefonofijo;

	@Column(name="REF_DOMICILIO", length=70)
	private String refDomicilio;

	@Column(length=1)
	private String sexo;

	@Column(name="TIP_CORREO", length=1)
	private String tipCorreo;

	@Column(name="TIP_DOCUMENTO", precision=3)
	private Integer tipDocumento;

	@Column(length=9)
	private String ubigeo;

	public EeccDemografico() {
	}

	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDirAdicional() {
		return this.dirAdicional;
	}

	public void setDirAdicional(String dirAdicional) {
		this.dirAdicional = dirAdicional;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getEnvEecccorreo() {
		return this.envEecccorreo;
	}

	public void setEnvEecccorreo(String envEecccorreo) {
		this.envEecccorreo = envEecccorreo;
	}

	public String getEstCivil() {
		return this.estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getFecNacimiento() {
		return this.fecNacimiento;
	}

	public void setFecNacimiento(String fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public BigDecimal getIdCentroalta() {
		return this.idCentroalta;
	}

	public void setIdCentroalta(BigDecimal idCentroalta) {
		this.idCentroalta = idCentroalta;
	}

	public BigDecimal getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(BigDecimal idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getIdFecvencimiento() {
		return this.idFecvencimiento;
	}

	public void setIdFecvencimiento(String idFecvencimiento) {
		this.idFecvencimiento = idFecvencimiento;
	}

	public String getIdNrocuenta() {
		return this.idNrocuenta;
	}

	public void setIdNrocuenta(String idNrocuenta) {
		this.idNrocuenta = idNrocuenta;
	}

	public String getIdNrodocumento() {
		return this.idNrodocumento;
	}

	public void setIdNrodocumento(String idNrodocumento) {
		this.idNrodocumento = idNrodocumento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumTelefonocelular() {
		return this.numTelefonocelular;
	}

	public void setNumTelefonocelular(String numTelefonocelular) {
		this.numTelefonocelular = numTelefonocelular;
	}

	public String getNumTelefonofijo() {
		return this.numTelefonofijo;
	}

	public void setNumTelefonofijo(String numTelefonofijo) {
		this.numTelefonofijo = numTelefonofijo;
	}

	public String getRefDomicilio() {
		return this.refDomicilio;
	}

	public void setRefDomicilio(String refDomicilio) {
		this.refDomicilio = refDomicilio;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipCorreo() {
		return this.tipCorreo;
	}

	public void setTipCorreo(String tipCorreo) {
		this.tipCorreo = tipCorreo;
	}

	public Integer getTipDocumento() {
		return this.tipDocumento;
	}

	public void setTipDocumento(Integer tipDocumento) {
		this.tipDocumento = tipDocumento;
	}

	public String getUbigeo() {
		return this.ubigeo;
	}

	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

}