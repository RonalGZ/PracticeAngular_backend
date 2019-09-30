package bco.visorhc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bco.visorhc.model.BdcTarjeta;
import bco.visorhc.service.IBdcTarjetaService;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/api/tarjeta")
public class BdcTarjetaController {
	
	private final Logger log = Logger.getLogger(BdcTarjetaController.class);
	
	@Autowired
	private IBdcTarjetaService service;
	
	@GetMapping(value = "/listarTarjetas/{nroCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BdcTarjeta>> listarTarjetas(@PathVariable(value = "nroCuenta") String nroCuenta) {
		List<BdcTarjeta> demoList = new ArrayList<BdcTarjeta>();
		try {
			demoList = service.listarTarjetas(nroCuenta);
			
//			for (BdcTarjeta t : demoList) {
//			    if (t.getIdTarjeta().length() == 16) {
//			        t.setIdTarjeta(enmascararTarjeta(t.getIdTarjeta(),0,12,"******"));
//			    }
//			}
			
			demoList.stream().filter(t-> t.getIdTarjeta().length() == 16).forEach(x->{
				x.setIdTarjeta(enmascararTarjeta(x.getIdTarjeta(),0,12,"******"));
			});

			log.info("listarTarjetas - OK");
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<BdcTarjeta>>(demoList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<BdcTarjeta>>(demoList, HttpStatus.OK);
	}
	
	@GetMapping(value="/listarContratos/{nroCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BdcTarjeta>> listarContratos(@PathVariable(value = "nroCuenta") String nroCuenta) {
		List<BdcTarjeta> demoList = new ArrayList<BdcTarjeta>();
		try {
			demoList = service.findListaContratos(nroCuenta);
//			for (BdcTarjeta t : demoList) {
//			    if (t.getIdTarjeta().length() == 16) {
//			        t.setIdTarjeta(enmascararTarjeta(t.getIdTarjeta(),0,12,"******"));
//			    }
//			}
			
			demoList.stream().filter(t-> t.getIdTarjeta().length() == 16).forEach(x->{
				x.setIdTarjeta(enmascararTarjeta(x.getIdTarjeta(),0,12,"******"));
			});
			
			log.info("listarContratos - OK");
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<List<BdcTarjeta>>(demoList, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<BdcTarjeta>>(demoList, HttpStatus.OK);
	}
	
	public String enmascararTarjeta(String s, int ini, int fin, String strRemplace) {
		return s.substring(0, 6) + strRemplace + s.substring(fin);
	}
}
