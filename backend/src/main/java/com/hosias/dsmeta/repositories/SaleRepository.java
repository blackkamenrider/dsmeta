package com.hosias.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hosias.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	//este repository é responsavel por fazer o crud no banco de dados...deletar, salvar , buscar etc...
   //aula 2 semana react tempo 37min e 50 sg +-
}




