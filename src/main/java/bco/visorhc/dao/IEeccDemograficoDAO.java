package bco.visorhc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bco.visorhc.model.EeccDemografico;

@Repository
public interface IEeccDemograficoDAO extends JpaRepository<EeccDemografico, Integer>{
		
	@Query("select d from EeccDemografico d where d.tipDocumento = :tipDocumento and TRIM(d.idNrodocumento) = :idNrodocumento ")
	EeccDemografico findByTipDocumentoAndIdNrodocumento(Integer tipDocumento, String idNrodocumento);
}
