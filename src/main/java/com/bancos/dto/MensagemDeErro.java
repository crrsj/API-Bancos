package com.bancos.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErro(HttpStatus status,String mensagem) {

}
