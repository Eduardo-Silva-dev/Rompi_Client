package br.com.rompi.cliente.adapters.out;

import br.com.rompi.cliente.adapters.out.integration.FindAddressByCepIntegration;
import br.com.rompi.cliente.adapters.out.integration.mapper.AddressResponseMapper;
import br.com.rompi.cliente.adapters.out.integration.response.AddressResponse;
import br.com.rompi.cliente.application.core.domain.Address;
import br.com.rompi.cliente.application.ports.out.FindAddressByCepOututPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByCepAdapter implements FindAddressByCepOututPort {

    private final FindAddressByCepIntegration findAddressByCepClient;

    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address execute(String cep) {
        AddressResponse addressResponse = findAddressByCepClient.execute(cep);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
