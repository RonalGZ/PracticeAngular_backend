package bco.visorhc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * The persistent class for the BDC_TARJETA database table.
 * 
 */
@Entity
//@Table(name="BDC_TARJETA", schema="EECC")
@Table(name="BDC_TARJETA")
public class BdcTarjeta {
	
	@Transient
	DateTime hoy = new DateTime();
	@Transient 
	DateTimeFormatter formatterBD = DateTimeFormat.forPattern("yyyyMMdd HH:mm:ss");
	
	@Transient
	private String estaVenci;
	

	@Id
	@Column(name="ID_TARJETA", nullable=false, length=22)
	private String idTarjeta;

	@Column(name="CALIDAD_PARTICIPACION", length=2)
	private String calidadParticipacion;

	@Column(name="DES_PRODUCTO", length=22)
	private String desProducto;

	@Column(name="ESTADO_TARJETA", length=50)
	private String estadoTarjeta;

	@Column(name="FECHA_ALTA", length=10)
	private String fechaAlta;

	@Column(name="FECHA_BAJA", length=10)
	private String fechaBaja;

	@Column(name="FECHA_CARGA", length=8)
	private String fechaCarga;

	@Column(name="FECHA_ULTIMO_BLOQUEO", length=10)
	private String fechaUltimoBloqueo;

	@Column(name="FECHA_VENCIMIENTO_TARJ", length=8)
	private String fechaVencimientoTarj;

	@Column(name="HORA_ULTIMO_BLOQUEO", length=10)
	private String horaUltimoBloqueo;

	@Column(name="IND_ORIGEN", length=3)
	private String indOrigen;

	@Column(name="IND_RAPICASH", length=4)
	private String indRapicash;

	@Column(name="IND_SUPERCASH", length=4)
	private String indSupercash;

	@Column(name="IND_ULTIMA_TARJETA", length=2)
	private String indUltimaTarjeta;

	@Column(name="MARCA_TARJETA", length=22)
	private String marcaTarjeta;

	@Column(name="MOTIVO_BAJA", length=2)
	private String motivoBaja;

	@Column(name="NOMBRE_EMBOCE", length=40)
	private String nombreEmboce;

	@Column(name="NRO_CUENTA", length=12)
	private String nroCuenta;

	@Column(name="NUMERO_DOCUMENTO", length=15)
	private String numeroDocumento;

	@Column(name="TIPO_DOCUMENTO", length=10)
	private String tipoDocumento;

	@Column(name="USR_ULTIMO_BLOQUEO", length=20)
	private String usrUltimoBloqueo;

	public BdcTarjeta() {
	}

	public String getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getCalidadParticipacion() {
		return this.calidadParticipacion;
	}

	public void setCalidadParticipacion(String calidadParticipacion) {
		this.calidadParticipacion = calidadParticipacion;
	}

	public String getDesProducto() {
		return this.desProducto;
	}

	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

	public String getEstadoTarjeta() {
		return this.estadoTarjeta;
	}

	public void setEstadoTarjeta(String estadoTarjeta) {
		this.estadoTarjeta = estadoTarjeta;
	}

	public String getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getFechaUltimoBloqueo() {
		return this.fechaUltimoBloqueo;
	}

	public void setFechaUltimoBloqueo(String fechaUltimoBloqueo) {
		this.fechaUltimoBloqueo = fechaUltimoBloqueo;
	}

	public String getFechaVencimientoTarj() {
		return this.fechaVencimientoTarj;
	}

	public void setFechaVencimientoTarj(String fechaVencimientoTarj) {
		this.fechaVencimientoTarj = fechaVencimientoTarj;
	}

	public String getHoraUltimoBloqueo() {
		return this.horaUltimoBloqueo;
	}

	public void setHoraUltimoBloqueo(String horaUltimoBloqueo) {
		this.horaUltimoBloqueo = horaUltimoBloqueo;
	}

	public String getIndOrigen() {
		return this.indOrigen;
	}

	public void setIndOrigen(String indOrigen) {
		this.indOrigen = indOrigen;
	}

	public String getIndRapicash() {
		return this.indRapicash;
	}

	public void setIndRapicash(String indRapicash) {
		this.indRapicash = indRapicash;
	}

	public String getIndSupercash() {
		return this.indSupercash;
	}

	public void setIndSupercash(String indSupercash) {
		this.indSupercash = indSupercash;
	}

	public String getIndUltimaTarjeta() {
		return this.indUltimaTarjeta;
	}

	public void setIndUltimaTarjeta(String indUltimaTarjeta) {
		this.indUltimaTarjeta = indUltimaTarjeta;
	}

	public String getMarcaTarjeta() {
		return this.marcaTarjeta;
	}

	public void setMarcaTarjeta(String marcaTarjeta) {
		this.marcaTarjeta = marcaTarjeta;
	}

	public String getMotivoBaja() {
		return this.motivoBaja;
	}

	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
	}

	public String getNombreEmboce() {
		return this.nombreEmboce;
	}

	public void setNombreEmboce(String nombreEmboce) {
		this.nombreEmboce = nombreEmboce;
	}

	public String getNroCuenta() {
		return this.nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	@Override
	public String toString() {
		return "BdcTarjeta [idTarjeta=" + idTarjeta + ", calidadParticipacion=" + calidadParticipacion
				+ ", desProducto=" + desProducto + ", estadoTarjeta=" + estadoTarjeta + ", fechaAlta=" + fechaAlta
				+ ", fechaBaja=" + fechaBaja + ", fechaCarga=" + fechaCarga + ", fechaUltimoBloqueo="
				+ fechaUltimoBloqueo + ", fechaVencimientoTarj=" + fechaVencimientoTarj + ", horaUltimoBloqueo="
				+ horaUltimoBloqueo + ", indOrigen=" + indOrigen + ", indRapicash=" + indRapicash + ", indSupercash="
				+ indSupercash + ", indUltimaTarjeta=" + indUltimaTarjeta + ", marcaTarjeta=" + marcaTarjeta
				+ ", motivoBaja=" + motivoBaja + ", nombreEmboce=" + nombreEmboce + ", nroCuenta=" + nroCuenta
				+ ", numeroDocumento=" + numeroDocumento + ", tipoDocumento=" + tipoDocumento + ", usrUltimoBloqueo="
				+ usrUltimoBloqueo + "]";
	}

	public String getUsrUltimoBloqueo() {
		return this.usrUltimoBloqueo;
	}

	public void setUsrUltimoBloqueo(String usrUltimoBloqueo) {
		this.usrUltimoBloqueo = usrUltimoBloqueo;
	}

	public String getEstaVenci() {
		try {
			DateTime fin = formatterBD.parseDateTime(fechaVencimientoTarj + " 00:00:00");
			int dias = Days.daysBetween(hoy.withTimeAtStartOfDay() , fin.withTimeAtStartOfDay() ).getDays();
			
			if(dias >= 0) {
				return "Vigente";
			}else {
				return "Vencido";
			}
		} catch (Exception e) {
			return "";
		}
	}

	public void setEstaVenci(String estaVenci) {
		this.estaVenci = estaVenci;
	}
	
	


}