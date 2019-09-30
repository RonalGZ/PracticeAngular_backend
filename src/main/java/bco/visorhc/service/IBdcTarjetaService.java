package bco.visorhc.service;

import java.util.List;

import bco.visorhc.model.BdcTarjeta;

public interface IBdcTarjetaService {
	
	List<BdcTarjeta>  listarTarjetas(String nroCuenta);
	
	List<BdcTarjeta>  findListaContratos(String nroCuenta);
}
