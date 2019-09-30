package bco.visorhc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bco.visorhc.model.EeccCabeceraEecc;

public interface IEeccCabeceraDAO extends JpaRepository <EeccCabeceraEecc, Long>{
	
	
	@Query("select d from EeccCabeceraEecc d "
			+ " where d.eeccCabeceraPK.idEntidad = :idEntidad "
			+ " and d.eeccCabeceraPK.idCentroalta = :idCentroalta "
			+ " and cast(d.eeccCabeceraPK.idNrocuenta as integer) = cast(:idNrocuenta as integer) "
			+ " and SUBSTRING(d.eeccCabeceraPK.idFecvencimiento, 1, 6) = :idFecvencimiento")
	List<EeccCabeceraEecc>  getEeCabecera(long idEntidad, long idCentroalta, String idNrocuenta,String idFecvencimiento );

}
