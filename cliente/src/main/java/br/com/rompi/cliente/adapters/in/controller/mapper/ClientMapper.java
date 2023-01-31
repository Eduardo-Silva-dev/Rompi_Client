package br.com.rompi.cliente.adapters.in.controller.mapper;

import br.com.rompi.cliente.adapters.in.controller.request.ClientRequest;
import br.com.rompi.cliente.adapters.in.controller.response.ClientResponse;
import br.com.rompi.cliente.application.core.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "address", ignore = true)
    Client toClient(ClientRequest clientRequest);

    ClientResponse toClientResponse(Client client);
}
