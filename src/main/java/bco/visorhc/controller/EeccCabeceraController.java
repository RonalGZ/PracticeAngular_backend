package bco.visorhc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bco.visorhc.model.EeccCabeceraEecc;
import bco.visorhc.service.IEeccCabeceraService;



@RestController
@RequestMapping("/api/eecc")
public class EeccCabeceraController {
	
	private final Logger log = Logger.getLogger(EeccCabeceraController.class);
	
	@Autowired
	private IEeccCabeceraService service;
	
	@GetMapping(value = "/obtenerEecc/{idEntidad}/{idCentroalta}/{idNrocuenta}/{idFecvencimiento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EeccCabeceraEecc>> listarCabecera(
			@PathVariable(value = "idEntidad") long idEntidad, 
			@PathVariable(value = "idCentroalta") long idCentroalta,
			@PathVariable(value = "idNrocuenta") String idNrocuenta,
			@PathVariable(value = "idFecvencimiento") String idFecvencimiento
			){
		List<EeccCabeceraEecc> demoList = new ArrayList<EeccCabeceraEecc>();
		try {
			demoList = service.obtenerCabecera(idEntidad, idCentroalta, idNrocuenta, idFecvencimiento);
			
			log.info("eecc - OK");
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<EeccCabeceraEecc>>(demoList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<EeccCabeceraEecc>>(demoList, HttpStatus.OK);
	
	}
	

}
