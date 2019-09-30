package bco.visorhc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bco.visorhc.model.BdcTarjeta;

@Repository
public interface IBdcTarjetaDAO extends JpaRepository <BdcTarjeta,String>{
	
	// obtiene lista de tarjetas
	@Query("select d from BdcTarjeta d where cast(d.nroCuenta as integer) = cast(:nroCuenta as integer)")
	List<BdcTarjeta>  findListarTarjetas(String nroCuenta);
	
	// Obtiene lista de contratos
	@Query("select d from BdcTarjeta d where cast(d.nroCuenta as integer) = cast(:nroCuenta as integer) and d.indUltimaTarjeta = 'S'")
	List<BdcTarjeta>  findListaContratos(String nroCuenta);
	
}
