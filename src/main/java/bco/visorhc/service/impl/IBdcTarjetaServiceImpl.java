package bco.visorhc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bco.visorhc.dao.IBdcTarjetaDAO;
import bco.visorhc.model.BdcTarjeta;
import bco.visorhc.service.IBdcTarjetaService;

@Service
public class IBdcTarjetaServiceImpl implements IBdcTarjetaService{

	@Autowired
	private IBdcTarjetaDAO dao;
	
	@Override
	public List<BdcTarjeta> listarTarjetas(String nroCuenta) {
		return dao.findListarTarjetas(nroCuenta);
	}

	@Override
	public List<BdcTarjeta> findListaContratos(String nroCuenta) {
		return dao.findListaContratos(nroCuenta);
	}

}
