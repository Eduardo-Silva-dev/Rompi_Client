package br.com.rompi.cliente.adapters.in.controller.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class ClientRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cep;
}
