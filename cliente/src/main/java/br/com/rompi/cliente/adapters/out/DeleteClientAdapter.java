package br.com.rompi.cliente.adapters.out;

import br.com.rompi.cliente.adapters.out.repository.ClientRespository;
import br.com.rompi.cliente.adapters.out.repository.entity.ClientEntity;
import br.com.rompi.cliente.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.out.DeleteClientOutputPort;
import br.com.rompi.cliente.application.ports.out.FindClientByIdOututPort;
import br.com.rompi.cliente.application.ports.out.InsertClientOutputPort;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeleteClientAdapter implements DeleteClientOutputPort {

    private final ClientRespository clientRespository;
    private final FindClientByIdOututPort findClientByIdOututPort;

    @Override
    @Transactional
    public void execute(long id) {
        if(findClientByIdOututPort.execute(id).isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }
        clientRespository.deleteById(id);
    }
}
