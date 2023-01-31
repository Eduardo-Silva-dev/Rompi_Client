package br.com.rompi.cliente.adapters.out.integration.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
