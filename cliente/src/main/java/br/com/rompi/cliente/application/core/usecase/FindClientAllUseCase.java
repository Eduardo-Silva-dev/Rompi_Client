package br.com.rompi.cliente.application.core.usecase;

import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.in.FindClientAllInputPort;
import br.com.rompi.cliente.application.ports.out.FindClientAllOututPort;

import java.util.List;

public class FindClientAllUseCase implements FindClientAllInputPort {

    private final FindClientAllOututPort findClientAllOututPort;

    public FindClientAllUseCase(FindClientAllOututPort findClientAllOututPort) {
        this.findClientAllOututPort = findClientAllOututPort;
    }

    @Override
    public List<Client> execute (){
        return findClientAllOututPort.execute();
    }

}
