package bco.visorhc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bco.visorhc.dao.IEeccDemograficoDAO;
import bco.visorhc.model.EeccDemografico;
import bco.visorhc.service.IEeccDemograficoService;

@Service
public class IEeccDemograficoServiceImpl implements IEeccDemograficoService{

	@Autowired
	private IEeccDemograficoDAO dao;

	@Override
	public EeccDemografico buscar(EeccDemografico obj) {
		return dao.findByTipDocumentoAndIdNrodocumento(obj.getTipDocumento(), obj.getIdNrodocumento());
	}



	

	
}
