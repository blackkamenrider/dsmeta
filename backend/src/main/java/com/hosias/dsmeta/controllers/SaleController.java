package com.hosias.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hosias.dsmeta.entities.Sale;
import com.hosias.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping //para este metodo respondeer com o procolo http q é o protocol da internet
	public List<Sale> findSales(){
			
		return service.findsales();				
	}
	
}
