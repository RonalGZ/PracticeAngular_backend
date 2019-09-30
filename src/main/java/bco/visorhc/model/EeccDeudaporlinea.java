package bco.visorhc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the EECC_DEUDAPORLINEA database table.
 * 
 */
@Entity
@Table(name="EECC_DEUDAPORLINEA")
public class EeccDeudaporlinea implements Serializable {
	private static final long serialVersionUID = 1L;

	//@JsonIgnore
	@EmbeddedId
	private EeccDeudaporlineaPK eeccDeudaporlineaPK;
	
	@Column(precision=12)
	private BigDecimal disponible;


	@Column(name="LIM_CREDITO", precision=12)
	private BigDecimal limCredito;

	@Column(name="SAL_DISPUESTO", precision=12)
	private BigDecimal salDispuesto;

	//bi-directional many-to-one association to EeccCabecera
	@JsonIgnore
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ID_CENTROALTA", referencedColumnName="ID_CENTROALTA", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ID_ENTIDAD", referencedColumnName="ID_ENTIDAD", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ID_FECVENCIMIENTO", referencedColumnName="ID_FECVENCIMIENTO", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ID_NROCUENTA", referencedColumnName="ID_NROCUENTA", nullable=false, insertable=false, updatable=false)
		})
	private EeccCabeceraEecc eeccCabeceraEecc;


	public EeccDeudaporlinea() {
	}

	public EeccDeudaporlineaPK getEeccDeudaporlineaPK() {
		return eeccDeudaporlineaPK;
	}

	public void setEeccDeudaporlineaPK(EeccDeudaporlineaPK eeccDeudaporlineaPK) {
		this.eeccDeudaporlineaPK = eeccDeudaporlineaPK;
	}

	public BigDecimal getDisponible() {
		return this.disponible;
	}

	public void setDisponible(BigDecimal disponible) {
		this.disponible = disponible;
	}

	public BigDecimal getLimCredito() {
		return this.limCredito;
	}

	public void setLimCredito(BigDecimal limCredito) {
		this.limCredito = limCredito;
	}

	public BigDecimal getSalDispuesto() {
		return this.salDispuesto;
	}

	public void setSalDispuesto(BigDecimal salDispuesto) {
		this.salDispuesto = salDispuesto;
	}
	
	@JsonIgnore
	public EeccCabeceraEecc getEeccCabecera() {
		return this.eeccCabeceraEecc;
	}
	@JsonIgnore
	public void setEeccCabecera(EeccCabeceraEecc eeccCabeceraEecc) {
		this.eeccCabeceraEecc = eeccCabeceraEecc;
	}

}