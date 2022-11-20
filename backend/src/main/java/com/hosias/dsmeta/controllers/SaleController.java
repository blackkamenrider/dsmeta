package com.hosias.dsmeta.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hosias.dsmeta.entities.Sale;
import com.hosias.dsmeta.services.SaleService;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping //para este metodo respondeer com o procolo http q é o protocol da internet
	public Page<Sale> findSales(
//as linhas debaixo sao argumentos da funçao findSales(apenas quebrei as linhas) este @requestParam com argumento significa: value=mindate é o nome que será chamado na web, o valor default é caso nao seja enviado nenum nome a minha funçao interpreta como vasio
			@RequestParam(value="minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "") String maxDate, 
			Pageable pageable){
			
		return service.findSales(minDate, maxDate, pageable);				
	}
	
}
