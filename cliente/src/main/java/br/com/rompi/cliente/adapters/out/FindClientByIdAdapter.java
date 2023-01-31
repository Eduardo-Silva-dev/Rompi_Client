package br.com.rompi.cliente.adapters.out;

import br.com.rompi.cliente.adapters.out.repository.ClientRespository;
import br.com.rompi.cliente.adapters.out.repository.entity.ClientEntity;
import br.com.rompi.cliente.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.out.FindClientByIdOututPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindClientByIdAdapter implements FindClientByIdOututPort {

    private final ClientRespository clientRespository;
    private final ClientEntityMapper clientEntityMapper;

    @Override
    public Optional<Client> execute(long id) {
        Optional<ClientEntity> clientEntity = clientRespository.findById(id);
        return clientEntity.map(entity -> clientEntityMapper.toClient(entity));
    }
}
