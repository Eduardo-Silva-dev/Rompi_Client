package br.com.rompi.cliente.adapters.in.controller.response;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class ClientResponse extends RepresentationModel<ClientResponse> {

    private long id;

    private String nome;

    private String sobrenome;

    private AddressResponse address;
}
