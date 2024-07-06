package com.bancos.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bancos.dto.BancoDto;
import com.bancos.model.Banco;
import com.bancos.repository.BancoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BancoService {
	
	private final BancoRepository bancoRepository;
	
	public Banco cadastrarBanco(BancoDto banco) {
		var cadastrarBanco = new Banco(banco);
		return bancoRepository.save(cadastrarBanco);
	}

	public List<Banco>listarBancos(){
		return bancoRepository.findAll();
	}
	public Banco buscarBancoPorId(Long id) {
		Optional<Banco>buscar = bancoRepository.findById(id);
		return buscar.orElseThrow(NoSuchElementException::new);
	}
	
	public Banco atualizarBanco(BancoDto banco,Long id) {
		var atualizarBanco = new Banco(banco);
		atualizarBanco.setId(id);
		return bancoRepository.save(atualizarBanco);
	}
	
	public void excluir(Long id) {
		bancoRepository.deleteById(id);
	}
	
	public Banco buscarPorNome(String nome) {
		
	return  bancoRepository.findByNome(nome.trim().toUpperCase());
		
	}
	public Banco buscarPorCodigo(String codigo) {
		return bancoRepository.findByCodigo(codigo);
	}
}
