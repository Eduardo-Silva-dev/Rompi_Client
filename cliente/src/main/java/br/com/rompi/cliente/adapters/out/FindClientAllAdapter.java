package br.com.rompi.cliente.adapters.out;

import br.com.rompi.cliente.adapters.out.repository.ClientRespository;
import br.com.rompi.cliente.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.out.FindClientAllOututPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindClientAllAdapter implements FindClientAllOututPort {

    private final ClientRespository clientRespository;
    private final ClientEntityMapper clientEntityMapper;

    @Override
    public List<Client> execute() {
        return clientRespository.findAll().stream().map(client -> clientEntityMapper.toClient(client)).collect(Collectors.toList());
    }
}
