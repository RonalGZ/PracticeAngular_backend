package bco.visorhc.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EECC_CABECERA_EECC database table.
 * 
 */
@Entity
@Table(name="EECC_CABECERA_EECC")
public class EeccCabeceraEecc implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
	private EeccCabeceraPK eeccCabeceraPK;
	
	// Campos calculados
	@Transient
	private BigDecimal totalLineaCredito;
	
	@Transient
	private BigDecimal totalDisponible;
	
	@Transient
	private BigDecimal deudaAlaFecha;
	
	@Transient
	private String fechaAl;
	
	@Transient
	private BigDecimal deudaTotalAl;
	
	@Transient
	private String tipoCredDesc;
	
	@Transient
	private double temCalculado;

	@Column(name="CAP_CUOTA", precision=10, scale=2)
	private BigDecimal capCuota;

	@Column(name="CAPITAL_VENCER", precision=12, scale=2)
	private BigDecimal capitalVencer;

	@Column(name="COM_CUOTAS", precision=12, scale=2)
	private BigDecimal comCuotas;

	@Column(name="COM_GASTOSPROYECTADOS", precision=9, scale=2)
	private BigDecimal comGastosproyectados;

	@Column(name="COM_UNACUOTA", precision=12, scale=2)
	private BigDecimal comUnacuota;

	@Column(length=10)
	private String correlativo;

	@Column(name="CUO_DEUDA", precision=12, scale=2)
	private BigDecimal cuoDeuda;

	@Column(name="CUO_MES", precision=12, scale=2)
	private BigDecimal cuoMes;

	@Column(name="CUOTA_VENCER", precision=12, scale=2)
	private BigDecimal cuotaVencer;

	@Column(name="DES_OPCIONPAGO", length=4)
	private String desOpcionpago;

	@Column(name="DEU_TOTAL", precision=12, scale=2)
	private BigDecimal deuTotal;

	@Column(name="DEU_VENCIDA", precision=12, scale=2)
	private BigDecimal deuVencida;

	@Column(name="FEC_CARGA", length=8)
	private String fecCarga;

	@Column(name="FEC_FACTURACION", length=10)
	private String fecFacturacion;

	@Column(name="FEC_RANGOINICIAL", length=10)
	private String fecRangoinicial;


	@Column(name="IMP_ITF", precision=10, scale=2)
	private BigDecimal impItf;

	@Column(name="INT_COMISIONGASTOS", precision=12, scale=2)
	private BigDecimal intComisiongastos;

	@Column(name="INT_COMISIONGASTOSROT", precision=12, scale=2)
	private BigDecimal intComisiongastosrot;

	@Column(name="INT_CUOTA", precision=10, scale=2)
	private BigDecimal intCuota;

	@Column(name="INT_PROYECTADO", precision=9, scale=2)
	private BigDecimal intProyectado;

	@Column(name="MIN_CAPITALIZACION", precision=10, scale=2)
	private BigDecimal minCapitalizacion;

	@Column(name="MIN_GASTOSYCOMISIONES", precision=10, scale=2)
	private BigDecimal minGastosycomisiones;

	@Column(name="MIN_INTERES", precision=10, scale=2)
	private BigDecimal minInteres;

	@Column(name="MON_INTERESES", precision=10, scale=2)
	private BigDecimal monIntereses;

	@Column(name="MON_VENCIMIENTO", precision=12, scale=2)
	private BigDecimal monVencimiento;

	@Column(name="NRO_MESESCANCELARDEUDA", precision=3)
	private BigDecimal nroMesescancelardeuda;

	@Column(name="OPC_PAGO", length=1)
	private String opcPago;

	@Column(precision=12, scale=2)
	private BigDecimal pagos;

	@Column(length=19)
	private String pan;

	@Column(name="RANG_PERIODO", length=18)
	private String rangPeriodo;

	@Column(name="SAL_FACTURADO", precision=12, scale=2)
	private BigDecimal salFacturado;

	@Column(name="SAL_FACTURADOANTERIOR", precision=12, scale=2)
	private BigDecimal salFacturadoanterior;

	@Column(name="TASA_ANUAL_MENSUAL", precision=12, scale=2)
	private BigDecimal tasaAnualMensual;

	@Column(name="TASA_INTERES_MENSUAL", precision=12, scale=2)
	private BigDecimal tasaInteresMensual;

	@Column(precision=12, scale=2)
	private BigDecimal tea;

	@Column(name="TIP_CREDITO", length=1)
	private String tipCredito;

	@Column(name="TIP_TARJETA", length=1)
	private String tipTarjeta;

	@Column(name="TOT_CAPITAL", precision=10, scale=2)
	private BigDecimal totCapital;

	@Column(name="TOT_CAPITALIZACION", precision=10, scale=2)
	private BigDecimal totCapitalizacion;

	@Column(name="TOT_DISPONIBLE", precision=12, scale=2)
	private BigDecimal totDisponible;

	@Column(name="TOT_GASTOSCOMISIONES", precision=10, scale=2)
	private BigDecimal totGastoscomisiones;

	@Column(name="TOT_INTERES", precision=10, scale=2)
	private BigDecimal totInteres;

	@Column(name="TOT_LIMITECREDITO", precision=12, scale=2)
	private BigDecimal totLimitecredito;

	@Column(name="TOT_SALDODISPUESTO", precision=12, scale=2)
	private BigDecimal totSaldodispuesto;

	//bi-directional many-to-one association to EeccDetalle
	@OneToMany(mappedBy="eeccCabeceraEecc")
	private List<EeccDetalleEecc> eeccDetalleEecc;

	//bi-directional many-to-one association to EeccDeudaporlinea
	@OneToMany(mappedBy="eeccCabeceraEecc")
	private List<EeccDeudaporlinea> eeccDeudaporlineas;
	
	public EeccCabeceraEecc() {
	}
	public EeccCabeceraPK getEeccCabeceraPK() {
		return eeccCabeceraPK;
	}



	public void setEeccCabeceraPK(EeccCabeceraPK eeccCabeceraPK) {
		this.eeccCabeceraPK = eeccCabeceraPK;
	}

	public BigDecimal getCapCuota() {
		return this.capCuota;
	}

	public void setCapCuota(BigDecimal capCuota) {
		this.capCuota = capCuota;
	}

	public BigDecimal getCapitalVencer() {
		return this.capitalVencer;
	}

	public void setCapitalVencer(BigDecimal capitalVencer) {
		this.capitalVencer = capitalVencer;
	}

	public BigDecimal getComCuotas() {
		return this.comCuotas;
	}

	public void setComCuotas(BigDecimal comCuotas) {
		this.comCuotas = comCuotas;
	}

	public BigDecimal getComGastosproyectados() {
		return this.comGastosproyectados;
	}

	public void setComGastosproyectados(BigDecimal comGastosproyectados) {
		this.comGastosproyectados = comGastosproyectados;
	}

	public BigDecimal getComUnacuota() {
		return this.comUnacuota;
	}

	public void setComUnacuota(BigDecimal comUnacuota) {
		this.comUnacuota = comUnacuota;
	}

	public String getCorrelativo() {
		return this.correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	public BigDecimal getCuoDeuda() {
		return this.cuoDeuda;
	}

	public void setCuoDeuda(BigDecimal cuoDeuda) {
		this.cuoDeuda = cuoDeuda;
	}

	public BigDecimal getCuoMes() {
		return this.cuoMes;
	}

	public void setCuoMes(BigDecimal cuoMes) {
		this.cuoMes = cuoMes;
	}

	public BigDecimal getCuotaVencer() {
		return this.cuotaVencer;
	}

	public void setCuotaVencer(BigDecimal cuotaVencer) {
		this.cuotaVencer = cuotaVencer;
	}

	public String getDesOpcionpago() {
		return this.desOpcionpago;
	}

	public void setDesOpcionpago(String desOpcionpago) {
		this.desOpcionpago = desOpcionpago;
	}

	public BigDecimal getDeuTotal() {
		return this.deuTotal;
	}

	public void setDeuTotal(BigDecimal deuTotal) {
		this.deuTotal = deuTotal;
	}

	public BigDecimal getDeuVencida() {
		return this.deuVencida;
	}

	public void setDeuVencida(BigDecimal deuVencida) {
		this.deuVencida = deuVencida;
	}

	public String getFecCarga() {
		return this.fecCarga;
	}

	public void setFecCarga(String fecCarga) {
		this.fecCarga = fecCarga;
	}

	public String getFecFacturacion() {
		return this.fecFacturacion;
	}

	public void setFecFacturacion(String fecFacturacion) {
		this.fecFacturacion = fecFacturacion;
	}

	public String getFecRangoinicial() {
		return this.fecRangoinicial;
	}

	public void setFecRangoinicial(String fecRangoinicial) {
		this.fecRangoinicial = fecRangoinicial;
	}


	public BigDecimal getImpItf() {
		return this.impItf;
	}

	public void setImpItf(BigDecimal impItf) {
		this.impItf = impItf;
	}

	public BigDecimal getIntComisiongastos() {
		return this.intComisiongastos;
	}

	public void setIntComisiongastos(BigDecimal intComisiongastos) {
		this.intComisiongastos = intComisiongastos;
	}

	public BigDecimal getIntComisiongastosrot() {
		return this.intComisiongastosrot;
	}

	public void setIntComisiongastosrot(BigDecimal intComisiongastosrot) {
		this.intComisiongastosrot = intComisiongastosrot;
	}

	public BigDecimal getIntCuota() {
		return this.intCuota;
	}

	public void setIntCuota(BigDecimal intCuota) {
		this.intCuota = intCuota;
	}

	public BigDecimal getIntProyectado() {
		return this.intProyectado;
	}

	public void setIntProyectado(BigDecimal intProyectado) {
		this.intProyectado = intProyectado;
	}

	public BigDecimal getMinCapitalizacion() {
		return this.minCapitalizacion;
	}

	public void setMinCapitalizacion(BigDecimal minCapitalizacion) {
		this.minCapitalizacion = minCapitalizacion;
	}

	public BigDecimal getMinGastosycomisiones() {
		return this.minGastosycomisiones;
	}

	public void setMinGastosycomisiones(BigDecimal minGastosycomisiones) {
		this.minGastosycomisiones = minGastosycomisiones;
	}

	public BigDecimal getMinInteres() {
		return this.minInteres;
	}

	public void setMinInteres(BigDecimal minInteres) {
		this.minInteres = minInteres;
	}

	public BigDecimal getMonIntereses() {
		return this.monIntereses;
	}

	public void setMonIntereses(BigDecimal monIntereses) {
		this.monIntereses = monIntereses;
	}

	public BigDecimal getMonVencimiento() {
		return this.monVencimiento;
	}

	public void setMonVencimiento(BigDecimal monVencimiento) {
		this.monVencimiento = monVencimiento;
	}

	public BigDecimal getNroMesescancelardeuda() {
		return this.nroMesescancelardeuda;
	}

	public void setNroMesescancelardeuda(BigDecimal nroMesescancelardeuda) {
		this.nroMesescancelardeuda = nroMesescancelardeuda;
	}

	public String getOpcPago() {
		return this.opcPago;
	}

	public void setOpcPago(String opcPago) {
		this.opcPago = opcPago;
	}

	public BigDecimal getPagos() {
		return this.pagos;
	}

	public void setPagos(BigDecimal pagos) {
		this.pagos = pagos;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getRangPeriodo() {
		return this.rangPeriodo;
	}

	public void setRangPeriodo(String rangPeriodo) {
		this.rangPeriodo = rangPeriodo;
	}

	public BigDecimal getSalFacturado() {
		return this.salFacturado;
	}

	public void setSalFacturado(BigDecimal salFacturado) {
		this.salFacturado = salFacturado;
	}

	public BigDecimal getSalFacturadoanterior() {
		return this.salFacturadoanterior;
	}

	public void setSalFacturadoanterior(BigDecimal salFacturadoanterior) {
		this.salFacturadoanterior = salFacturadoanterior;
	}

	public BigDecimal getTasaAnualMensual() {
		return this.tasaAnualMensual;
	}

	public void setTasaAnualMensual(BigDecimal tasaAnualMensual) {
		this.tasaAnualMensual = tasaAnualMensual;
	}

	public BigDecimal getTasaInteresMensual() {
		return this.tasaInteresMensual;
	}

	public void setTasaInteresMensual(BigDecimal tasaInteresMensual) {
		this.tasaInteresMensual = tasaInteresMensual;
	}

	public BigDecimal getTea() {
		return this.tea;
	}

	public void setTea(BigDecimal tea) {
		this.tea = tea;
	}

	public String getTipCredito() {
		return this.tipCredito;
	}

	public void setTipCredito(String tipCredito) {
		this.tipCredito = tipCredito;
	}

	public String getTipTarjeta() {
		return this.tipTarjeta;
	}

	public void setTipTarjeta(String tipTarjeta) {
		this.tipTarjeta = tipTarjeta;
	}

	public BigDecimal getTotCapital() {
		return this.totCapital;
	}

	public void setTotCapital(BigDecimal totCapital) {
		this.totCapital = totCapital;
	}

	public BigDecimal getTotCapitalizacion() {
		return this.totCapitalizacion;
	}

	public void setTotCapitalizacion(BigDecimal totCapitalizacion) {
		this.totCapitalizacion = totCapitalizacion;
	}

	public BigDecimal getTotDisponible() {
		return this.totDisponible;
	}

	public void setTotDisponible(BigDecimal totDisponible) {
		this.totDisponible = totDisponible;
	}

	public BigDecimal getTotGastoscomisiones() {
		return this.totGastoscomisiones;
	}

	public void setTotGastoscomisiones(BigDecimal totGastoscomisiones) {
		this.totGastoscomisiones = totGastoscomisiones;
	}

	public BigDecimal getTotInteres() {
		return this.totInteres;
	}

	public void setTotInteres(BigDecimal totInteres) {
		this.totInteres = totInteres;
	}

	public BigDecimal getTotLimitecredito() {
		return this.totLimitecredito;
	}

	public void setTotLimitecredito(BigDecimal totLimitecredito) {
		this.totLimitecredito = totLimitecredito;
	}

	public BigDecimal getTotSaldodispuesto() {
		return this.totSaldodispuesto;
	}

	public void setTotSaldodispuesto(BigDecimal totSaldodispuesto) {
		this.totSaldodispuesto = totSaldodispuesto;
	}

	public List<EeccDetalleEecc> getEeccDetalleEecc() {
		return eeccDetalleEecc;
	}
	public void setEeccDetalleEecc(List<EeccDetalleEecc> eeccDetalleEecc) {
		this.eeccDetalleEecc = eeccDetalleEecc;
	}
	public List<EeccDeudaporlinea> getEeccDeudaporlineas() {
		return this.eeccDeudaporlineas;
	}

	public void setEeccDeudaporlineas(List<EeccDeudaporlinea> eeccDeudaporlineas) {
		this.eeccDeudaporlineas = eeccDeudaporlineas;
	}

	
	// MODIFICADOS
	public BigDecimal getTotalLineaCredito() {
		BigDecimal suma = new BigDecimal(0);
		for (EeccDeudaporlinea e : eeccDeudaporlineas) {
			if(e.getEeccDeudaporlineaPK().getIdLinea() == 1L 
					|| e.getEeccDeudaporlineaPK().getIdLinea() == 2L 
					|| e.getEeccDeudaporlineaPK().getIdLinea() == 3L) {
			 suma = suma.add(e.getLimCredito());
			}			
		}
		return suma;
	}
	
	public void setTotalLineaCredito(BigDecimal totalLineaCredito) {
		this.totalLineaCredito = totalLineaCredito;
	}
	public BigDecimal getTotalDisponible() {
		BigDecimal suma = new BigDecimal(0);
		for (EeccDeudaporlinea e : eeccDeudaporlineas) {
			if(e.getEeccDeudaporlineaPK().getIdLinea() == 1L 
					|| e.getEeccDeudaporlineaPK().getIdLinea() == 2L
					|| e.getEeccDeudaporlineaPK().getIdLinea() == 3L) {
				suma = suma.add(e.getDisponible());
			}			
		}
		return suma;
	}
	public void setTotalDisponible(BigDecimal totalDisponible) {
		this.totalDisponible = totalDisponible;
	}
	
	public BigDecimal getDeudaAlaFecha() {
		return deuVencida.add(cuotaVencer);
	}
	public void setDeudaAlaFecha(BigDecimal deudaAlaFecha) {
		this.deudaAlaFecha = deudaAlaFecha;
	}
	
	public String getFechaAl() {
		if(rangPeriodo.isEmpty() || rangPeriodo != null) {
			return rangPeriodo.substring(4, 9);
		}else {
			return "";
		}
		
	}
	public void setFechaAl(String fechaAl) {
		this.fechaAl = fechaAl;
	}
	
	public BigDecimal getDeudaTotalAl() {
		return deuVencida.add(deuTotal);
	}
	public void setDeudaTotalAl(BigDecimal deudaTotalAl) {
		this.deudaTotalAl = deudaTotalAl;
	}
	
	public String getTipoCredDesc() {
		if("R".equals(tipCredito)) {
			return "Sistema Rotativo";
		}else {
			return tipCredito;
		}
	}
	public void setTipoCredDesc(String tipoCredDesc) {
		this.tipoCredDesc = tipoCredDesc;
	}
	public double getTemCalculado() {
		Double dbTEA = this.tea.doubleValue();
		Double interes = null;
		interes = (Math.pow((1.0 + dbTEA), (1.0 / 12.0)) -1.0);
		interes= (double) Math.round(interes * 100) / 100;
		return interes;
	}
	public void setTemCalculado(double temCalculado) {
		this.temCalculado = temCalculado;
	}
	
	
	
	
	
	
	
	
	
}