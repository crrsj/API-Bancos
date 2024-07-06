package com.bancos.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bancos.model.Banco;

public interface BancoRepository extends JpaRepository<Banco, Long> {
	@Query(value = "select b from Banco b where upper(trim(b.nome)) like %?1% ") 
	Banco findByNome(String nome);
	@Query(value = "select b from Banco b where upper(trim(b.codigo)) like %?1% ") 
	Banco findByCodigo(String codigo);
     
}
