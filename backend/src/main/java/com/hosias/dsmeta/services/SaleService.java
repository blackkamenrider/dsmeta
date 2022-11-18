package com.hosias.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hosias.dsmeta.entities.Sale;
import com.hosias.dsmeta.repositories.SaleRepository;

//componete responsavel or fazer operaçoes com vendas
@Service //registrando o saleservice como um componente do sistema
public class SaleService {
	
	
	//quem acessa o bd no meu programa é o repository entao tenho q declarar ele
	
	@Autowired // faz importaçao automatica
	private SaleRepository repository;
	
	
   //funçao que busca as vendas
	public List<Sale> findsales(){
		
		
		
		return 	repository.findAll();
	}
}
