package bco.visorhc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EECC_DEUDAPORLINEA database table.
 * 
 */
@Embeddable
public class EeccDeudaporlineaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_LINEA",  nullable=false, precision=4)
	private long idLinea;

	@Column(name="ID_ENTIDAD", nullable=false, precision=4)
	private long idEntidad;

	@Column(name="ID_CENTROALTA", nullable=false, precision=4)
	private long idCentroalta;

	@Column(name="ID_NROCUENTA", nullable=false, length=16)
	private String idNrocuenta;

	@Column(name="ID_FECVENCIMIENTO", unique=true, nullable=false, length=10)
	private String idFecvencimiento;

	public EeccDeudaporlineaPK() {
	}
	public long getIdLinea() {
		return this.idLinea;
	}
	public void setIdLinea(long idLinea) {
		this.idLinea = idLinea;
	}
	public long getIdEntidad() {
		return this.idEntidad;
	}
	public void setIdEntidad(long idEntidad) {
		this.idEntidad = idEntidad;
	}
	public long getIdCentroalta() {
		return this.idCentroalta;
	}
	public void setIdCentroalta(long idCentroalta) {
		this.idCentroalta = idCentroalta;
	}
	public String getIdNrocuenta() {
		return this.idNrocuenta;
	}
	public void setIdNrocuenta(String idNrocuenta) {
		this.idNrocuenta = idNrocuenta;
	}
	public String getIdFecvencimiento() {
		return this.idFecvencimiento;
	}
	public void setIdFecvencimiento(String idFecvencimiento) {
		this.idFecvencimiento = idFecvencimiento;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EeccDeudaporlineaPK)) {
			return false;
		}
		EeccDeudaporlineaPK castOther = (EeccDeudaporlineaPK)other;
		return 
			(this.idLinea == castOther.idLinea)
			&& (this.idEntidad == castOther.idEntidad)
			&& (this.idCentroalta == castOther.idCentroalta)
			&& this.idNrocuenta.equals(castOther.idNrocuenta)
			&& this.idFecvencimiento.equals(castOther.idFecvencimiento);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idLinea ^ (this.idLinea >>> 32)));
		hash = hash * prime + ((int) (this.idEntidad ^ (this.idEntidad >>> 32)));
		hash = hash * prime + ((int) (this.idCentroalta ^ (this.idCentroalta >>> 32)));
		hash = hash * prime + this.idNrocuenta.hashCode();
		hash = hash * prime + this.idFecvencimiento.hashCode();
		
		return hash;
	}
}