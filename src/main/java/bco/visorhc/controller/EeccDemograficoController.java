package bco.visorhc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import bco.visorhc.model.EeccDemografico;
import bco.visorhc.service.IEeccDemograficoService;

@RestController
@RequestMapping("/api/demografico")
public class EeccDemograficoController {
	
	private final Logger log = Logger.getLogger(EeccDemograficoController.class);
	
	@Autowired
	private IEeccDemograficoService service;
	
	@PostMapping(value = "/buscar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EeccDemografico> buscarDemografico(@RequestBody EeccDemografico req) {
		EeccDemografico demoList = new EeccDemografico();
		try {
			demoList = service.buscar(req);
			log.info("buscar - OK");
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<EeccDemografico>(demoList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EeccDemografico>(demoList, HttpStatus.OK);
	}

}
