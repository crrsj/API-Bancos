package com.bancos.infra;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bancos.dto.MensagemDeErro;
import com.bancos.dto.TratandoErros;


@RestControllerAdvice
public class TratamentoDeErros {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErro>tratarErrosIdNaoEncontrado(){
	var erros =	new MensagemDeErro(HttpStatus.BAD_REQUEST, "ID não encontrado !");
		return ResponseEntity.badRequest().body(erros);
	}
    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
	public ResponseEntity<MensagemDeErro>CodigoNaoEncontrado(){
		var tratarErro = new MensagemDeErro(HttpStatus.BAD_REQUEST, "Código não encontrado");
		return ResponseEntity.badRequest().body(tratarErro);
	}
	
    @ExceptionHandler(NullPointerException.class)
   	public ResponseEntity<MensagemDeErro>BancoNaoEncontrado(){
   		var tratarErro = new MensagemDeErro(HttpStatus.BAD_REQUEST, "Banco  não encontrado ou digitado incorretamante,digite ex: Santander !");
   		return ResponseEntity.badRequest().body(tratarErro);
    }
    

	  @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        BindingResult result = ex.getBindingResult();
	        Map<String, String> errors = new HashMap<>();
	        for (FieldError error : result.getFieldErrors()) {
	            errors.put(error.getField(), error.getDefaultMessage());
	        }
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }
	
}
