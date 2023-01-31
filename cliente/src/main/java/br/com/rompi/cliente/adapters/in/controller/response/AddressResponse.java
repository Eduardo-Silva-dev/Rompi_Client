package br.com.rompi.cliente.adapters.in.controller.response;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class AddressResponse extends RepresentationModel<AddressResponse> {

    private long id;

    private String cep;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String uf;
}
