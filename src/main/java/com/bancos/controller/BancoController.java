package com.bancos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bancos.dto.BancoDto;
import com.bancos.service.BancoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("banco")
@RequiredArgsConstructor
public class BancoController {

	private final BancoService bancoService;
	
	@PostMapping	
	@Operation(summary = "Rota responsável pelo cadastro de bancos") 
    @ApiResponse(responseCode = "201",description = "Banco cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<BancoDto>cadastrarBanco(@RequestBody @Valid BancoDto banco){
		var cadastrarBanco = bancoService.cadastrarBanco(banco);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(cadastrarBanco.getId()).toUri();
		return ResponseEntity.created(uri).body(new BancoDto(cadastrarBanco));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os bancos")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<BancoDto>>listarBancos(){
		var listar = bancoService.listarBancos().stream().map(BancoDto::new).toList();
		return ResponseEntity.ok(listar);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável pela busca do banco pelo id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<BancoDto>buscarBancoPorId(@PathVariable Long id){
		var buscar = bancoService.buscarBancoPorId(id);
		return ResponseEntity.ok(new BancoDto(buscar));
	}
	
	@PutMapping("{id}")
	@Operation(summary = "Rota responsável por atualizar o banco pelo id")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<BancoDto>atualizarBanco(@RequestBody @Valid BancoDto banco, @PathVariable Long id){
		var atualizarBanco = bancoService.atualizarBanco(banco, id);
		return ResponseEntity.ok().body(new BancoDto(atualizarBanco));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar um banco pelo id")
	@ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })          
	public ResponseEntity<Void>excluirBanco(@PathVariable Long id){
		bancoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("buscarBanco")
	@Operation(summary = "Rota responsável por buscar bancos pelo nome")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<BancoDto>buscarBancoPorNome(@RequestParam(name = "nome") String nome){
		var buscaNome = bancoService.buscarPorNome(nome);
		return ResponseEntity.ok(new BancoDto(buscaNome));
	}
	
	@GetMapping("buscarPorCodigo")
	@Operation(summary = "Rota responsável por buscar bancos pelo código")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<BancoDto>buscarBancoPorCodigo(@RequestParam(name ="codigo") String codigo){
		var buscaCodigo = bancoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok(new BancoDto(buscaCodigo));
	}
}
