package bco.visorhc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bco.visorhc.dao.IEeccCabeceraDAO;
import bco.visorhc.model.EeccCabeceraEecc;
import bco.visorhc.service.IEeccCabeceraService;

@Service
public class IEeccCabeceraServiceImpl implements IEeccCabeceraService{

	@Autowired
	private IEeccCabeceraDAO dao;


	@Override
	public List<EeccCabeceraEecc> obtenerCabecera(long idEntidad, long idCentroalta, String idNrocuenta,
			String idFecvencimiento) {
		return dao.getEeCabecera(idEntidad, idCentroalta, idNrocuenta, idFecvencimiento);
	}



	

	
}
