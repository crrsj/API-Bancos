package com.bancos.model;

import org.hibernate.validator.constraints.br.CNPJ;

import com.bancos.dto.BancoDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bancos")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Banco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	private String nome;
	private String codigo;
	private String cnpj;
	private String site;
	private String foneCapital;
	private String foneOuraReg;
	
	public Banco(BancoDto banco) {
		this.id = banco.getId();
		this.nome = banco.getNome();
		this.codigo = banco.getCodigo();
		this.cnpj = banco.getCnpj();
		this.site = banco.getSite();
		this.foneCapital = banco.getFoneCapital();
		this.foneOuraReg = banco.getFoneOutraReg();
	}

}
