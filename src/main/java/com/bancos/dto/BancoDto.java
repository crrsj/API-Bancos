package com.bancos.dto;

import org.hibernate.validator.constraints.br.CNPJ;

import com.bancos.model.Banco;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BancoDto{
		
		Long id;
		@NotBlank(message = "Não pode estar em branco")
		@Column(unique = true)
		String nome;
		@NotBlank(message = "Não pode estar em branco")		
		String codigo;
		@CNPJ
		String cnpj;
		@NotBlank(message = "Não pode estar em branco")
		@Column(unique = true)
		String site;
		@NotBlank(message = "Não pode estar em branco")
		@Column(unique = true)
		String foneCapital;
		@NotBlank(message = "Não pode estar em branco")
		@Column(unique = true)
		String foneOutraReg;

	public BancoDto(Banco cadastrarBanco) {
	  this.id = cadastrarBanco.getId();
	  this.nome = cadastrarBanco.getNome();
	  this.codigo = cadastrarBanco.getCodigo();
	  this.cnpj = cadastrarBanco.getCnpj();
	  this.site = cadastrarBanco.getSite();
	  this.foneCapital = cadastrarBanco.getFoneCapital();
	  this.foneOutraReg = cadastrarBanco.getFoneOuraReg();
	}

}
