package br.com.rompi.cliente.adapters.out.integration.mapper;

import br.com.rompi.cliente.adapters.out.integration.response.AddressResponse;
import br.com.rompi.cliente.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
