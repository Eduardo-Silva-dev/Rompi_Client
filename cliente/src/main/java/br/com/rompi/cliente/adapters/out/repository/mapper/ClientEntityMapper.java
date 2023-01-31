package br.com.rompi.cliente.adapters.out.repository.mapper;

import br.com.rompi.cliente.adapters.out.repository.entity.ClientEntity;
import br.com.rompi.cliente.application.core.domain.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    ClientEntity toClientEntity(Client client);

    Client toClient(ClientEntity clientEntity);
}
