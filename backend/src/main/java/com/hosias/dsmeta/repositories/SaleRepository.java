package com.hosias.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hosias.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	//este repository é responsavel por fazer o crud no banco de dados...deletar, salvar , buscar etc...
   //aula 2 semana react tempo 37min e 50 sg +-
	
//JpaRepository nao tem uma funçao que receba duas datas e, como estou precisando na classe SaleService entao irei na linha a baixo criar esta funçao

	//esta linguagem dentro dos parentese depois de @query é uma linguagem jpql parecida com a sql porém, adaptada para o jpa
	//esta dizendo: seleciona todos objto obj do tipo sale obj sale ENTRE uma data minima e maxima que será definida pelos paramentros da funçao a baixo
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
	
}




