package bco.visorhc.service;

import java.util.List;

import bco.visorhc.model.EeccCabeceraEecc;

public interface IEeccCabeceraService {
		
	public List<EeccCabeceraEecc> obtenerCabecera(long idEntidad, long idCentroalta, String idNrocuenta, String idFecvencimiento );

}
