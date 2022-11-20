package com.hosias.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hosias.dsmeta.entities.Sale;
import com.hosias.dsmeta.repositories.SaleRepository;

//componete responsavel por fazer operaçoes com vendas
@Service //registrando o saleservice como um componente do sistema
public class SaleService {
	
	
	//quem acessa o bd no meu programa é o repository entao tenho q declarar ele
	
	@Autowired // faz importaçao automatica
	private SaleRepository repository;
	
	
   //funçao que busca as vendas
	
public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
	
//Esta linha a baixo foicriada para colocar no salecontroller quando usurio nao informar data nenhuma ser jogada pra ele como uma das datas a data do momento	
	LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()); // esta linha cria uma data no dia de hoje.//este ZoneId.systemDefault() pega o fuso orario o formato do aparelho do sistema usado no mmmento
	
	
	LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);//today.minusYars um metodo onde subtraio neste caso ano, mastem de meses dias e etc....
	LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);//maxDate.equalsé igual a vazio ? se for coloco a variavel today : se nao colocomaxDate convertida em data linha a frente. LocalDate.parse(maxDate)
	//usei a cima uma expressao que se chama condiçao ternaria 
	
	return repository.findSales(min, max, pageable);
}
		
	
}
