package br.com.rompi.cliente.adapters.out;

import br.com.rompi.cliente.adapters.out.repository.ClientRespository;
import br.com.rompi.cliente.adapters.out.repository.entity.ClientEntity;
import br.com.rompi.cliente.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.out.InsertClientOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InsertClientAdapter implements InsertClientOutputPort {

    private final ClientRespository clientRespository;
    private final ClientEntityMapper clientEntityMapper;

    @Override
    @Transactional
    public Client execute(Client client) {
        ClientEntity clientEntity = clientEntityMapper.toClientEntity(client);
        return clientEntityMapper.toClient(clientRespository.save(clientEntity));
    }
}
