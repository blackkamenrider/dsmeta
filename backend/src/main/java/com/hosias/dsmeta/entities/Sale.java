package com.hosias.dsmeta.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//classe sale (vendas em ingles) feita para mapear esta entidade(class sale) para que ela seja uma tabela de banco de dados

@Entity //mapeamento para o banco de dados relacional
@Table(name = "tb_sales") //especificano qual nome da tabela lá no banco de dados
public class Sale {
	@Id  // aqui diz: olha banco de dados, este id é unico porq é ele que identifica cada linha do banco de dados 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // aqui diz para o id ser implementado um a um
	private Long id;
	private String sellerName;      //vendedor
	private Integer visited;
	private Integer deals;          //vendas feitas acordo fechado etc..
	private Double amount;          //total em de vendas em dinheiro
	private LocalDate date;
	
	public Sale() {
		
	}
	
	

	public Sale(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {		
		this.id = id;
		this.sellerName = sellerName;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

}
