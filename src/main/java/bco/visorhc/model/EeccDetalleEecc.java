package bco.visorhc.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the EECC_DETALLE_EECC database table.
 * 
 */
@Entity
@Table(name="EECC_DETALLE_EECC")
public class EeccDetalleEecc implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private EeccDetalleEeccPK eeccDetallePK;
	
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
	
	// Parametros calculados
	@Transient
	private String cargoAbono;
	
	@Column(name="ADI_TITULAR", length=5)
	private String adiTitular;

	@Column(precision=16)
	private BigDecimal caja;

	@Column(precision=12, scale=2)
	private BigDecimal capital;

	@Column(name="CLAS_ESTADO", length=4)
	private String clasEstado;

	@Column(name="COD_COMERCIO", length=15)
	private String codComercio;

	@Column(name="COD_ORIG", precision=6)
	private BigDecimal codOrig;

	@Column(name="COD_TRANSACCION", precision=4)
	private BigDecimal codTransaccion;

	@Column(name="DES_COMERCIO", length=27)
	private String desComercio;

	@Column(name="DES_MOVIMIENTO", length=30)
	private String desMovimiento;

	@Column(length=20)
	private String establecimiento;

	@Column(name="FEC_CARGA", length=8)
	private String fecCarga;

	@Column(name="FEC_PROCESO", length=10)
	private String fecProceso;

	@Column(name="FEC_TRANSACCION", length=10)
	private String fecTransaccion;

	@Column(precision=12, scale=2)
	private BigDecimal interes;


	@Column(name="NRO_CUOTAS", length=5)
	private String nroCuotas;

	@Column(name="NRO_DOCUMENTO", precision=6)
	private BigDecimal nroDocumento;

	@Column(precision=1)
	private BigDecimal nucort;

	@Column(length=10)
	private String pais;

	@Column(name="PAIS_TRANSACCION", length=2)
	private String paisTransaccion;

	@Column(name="TASA_TRANSACCION", precision=22, scale=4)
	private BigDecimal tasaTransaccion;

	@Column(precision=7, scale=2)
	private BigDecimal tea;

	@Column(name="TIPO_MOVIMIENTO", precision=2)
	private BigDecimal tipoMovimiento;

	@Column(length=30)
	private String titadi;

	@Column(name="TITULAR_ADICIONAL", length=22)
	private String titularAdicional;

	@Column(length=30)
	private String upc;

	@Column(name="VAL_CUOTA", precision=12, scale=2)
	private BigDecimal valCuota;

	@Column(name="VAL_MOVIMIENTO", precision=12, scale=2)
	private BigDecimal valMovimiento;

	public EeccDetalleEecc() {
	}

	public String getAdiTitular() {
		return this.adiTitular;
	}

	public void setAdiTitular(String adiTitular) {
		this.adiTitular = adiTitular;
	}

	public BigDecimal getCaja() {
		return this.caja;
	}

	public void setCaja(BigDecimal caja) {
		this.caja = caja;
	}

	public BigDecimal getCapital() {
		return this.capital;
	}

	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}

	public String getClasEstado() {
		return this.clasEstado;
	}

	public void setClasEstado(String clasEstado) {
		this.clasEstado = clasEstado;
	}

	public String getCodComercio() {
		return this.codComercio;
	}

	public void setCodComercio(String codComercio) {
		this.codComercio = codComercio;
	}

	public BigDecimal getCodOrig() {
		return this.codOrig;
	}

	public void setCodOrig(BigDecimal codOrig) {
		this.codOrig = codOrig;
	}

	public BigDecimal getCodTransaccion() {
		return this.codTransaccion;
	}

	public void setCodTransaccion(BigDecimal codTransaccion) {
		this.codTransaccion = codTransaccion;
	}

	public String getDesComercio() {
		return this.desComercio;
	}

	public void setDesComercio(String desComercio) {
		this.desComercio = desComercio;
	}

	public String getDesMovimiento() {
		return this.desMovimiento;
	}

	public void setDesMovimiento(String desMovimiento) {
		this.desMovimiento = desMovimiento;
	}

	public String getEstablecimiento() {
		return this.establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getFecCarga() {
		return this.fecCarga;
	}

	public void setFecCarga(String fecCarga) {
		this.fecCarga = fecCarga;
	}

	public String getFecProceso() {
		return this.fecProceso;
	}

	public void setFecProceso(String fecProceso) {
		this.fecProceso = fecProceso;
	}

	public String getFecTransaccion() {
		return this.fecTransaccion;
	}

	public void setFecTransaccion(String fecTransaccion) {
		this.fecTransaccion = fecTransaccion;
	}

	
	public BigDecimal getInteres() {
		return this.interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public String getNroCuotas() {
		return this.nroCuotas;
	}

	public void setNroCuotas(String nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public BigDecimal getNroDocumento() {
		return this.nroDocumento;
	}

	public void setNroDocumento(BigDecimal nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public BigDecimal getNucort() {
		return this.nucort;
	}

	public void setNucort(BigDecimal nucort) {
		this.nucort = nucort;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPaisTransaccion() {
		return this.paisTransaccion;
	}

	public void setPaisTransaccion(String paisTransaccion) {
		this.paisTransaccion = paisTransaccion;
	}

	public BigDecimal getTasaTransaccion() {
		return this.tasaTransaccion;
	}

	public void setTasaTransaccion(BigDecimal tasaTransaccion) {
		this.tasaTransaccion = tasaTransaccion;
	}

	public BigDecimal getTea() {
		return this.tea;
	}

	public void setTea(BigDecimal tea) {
		this.tea = tea;
	}

	public BigDecimal getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(BigDecimal tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getTitadi() {
		return this.titadi;
	}

	public void setTitadi(String titadi) {
		this.titadi = titadi;
	}

	public String getTitularAdicional() {
		return this.titularAdicional;
	}

	public void setTitularAdicional(String titularAdicional) {
		this.titularAdicional = titularAdicional;
	}

	public String getUpc() {
		return this.upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public BigDecimal getValCuota() {
		return this.valCuota;
	}

	public void setValCuota(BigDecimal valCuota) {
		this.valCuota = valCuota;
	}

	public BigDecimal getValMovimiento() {
		return this.valMovimiento;
	}

	public void setValMovimiento(BigDecimal valMovimiento) {
		this.valMovimiento = valMovimiento;
	}

	public EeccDetalleEeccPK getEeccDetallePK() {
		return eeccDetallePK;
	}

	public void setEeccDetallePK(EeccDetalleEeccPK eeccDetallePK) {
		this.eeccDetallePK = eeccDetallePK;
	}

	public EeccCabeceraEecc getEeccCabeceraEecc() {
		return eeccCabeceraEecc;
	}

	public void setEeccCabeceraEecc(EeccCabeceraEecc eeccCabeceraEecc) {
		this.eeccCabeceraEecc = eeccCabeceraEecc;
	}


	
	//Calculados
	public String getCargoAbono() {
		String result = "";
		if (valCuota.signum() > 0) {
			result = valCuota.toPlainString();
		} else {
			result = "("+valCuota.abs().toPlainString()+")";
		}
		return  result;
	}

	public void setCargoAbono(String cargoAbono) {
		this.cargoAbono = cargoAbono;
	}

	

}