package br.com.rompi.cliente.adapters.out;

import br.com.rompi.cliente.adapters.out.repository.ClientRespository;
import br.com.rompi.cliente.adapters.out.repository.entity.ClientEntity;
import br.com.rompi.cliente.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.out.FindClientByIdOututPort;
import br.com.rompi.cliente.application.ports.out.UpdateClientOutputPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateClientAdapter implements UpdateClientOutputPort {

    private final ClientRespository clientRespository;
    private final ClientEntityMapper clientEntityMapper;
    private final FindClientByIdOututPort findClientByIdOututPort;

    @Override
    @Transactional
    public Client execute(Client client) {
        if(findClientByIdOututPort.execute(client.getId()).isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }
        ClientEntity clientEntity = clientEntityMapper.toClientEntity(client);
        return clientEntityMapper.toClient(clientRespository.save(clientEntity));
    }
}
