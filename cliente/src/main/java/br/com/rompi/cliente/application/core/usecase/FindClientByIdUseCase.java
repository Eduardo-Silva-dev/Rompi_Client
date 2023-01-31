package br.com.rompi.cliente.application.core.usecase;

import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.in.FindClientByIdInputPort;
import br.com.rompi.cliente.application.ports.out.FindClientByIdOututPort;

import java.util.Optional;

public class FindClientByIdUseCase implements FindClientByIdInputPort {

    private final FindClientByIdOututPort findAddressByCepOututPort;

    public FindClientByIdUseCase(FindClientByIdOututPort findAddressByCepOututPort) {
        this.findAddressByCepOututPort = findAddressByCepOututPort;
    }

    @Override
    public Optional<Client> execute (long id){
        return findAddressByCepOututPort.execute(id);
    }

}
