package br.com.rompi.cliente.application.core.usecase;

import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.in.FindClientByIdInputPort;
import br.com.rompi.cliente.application.ports.in.UpdateClientInputPort;
import br.com.rompi.cliente.application.ports.out.FindAddressByCepOututPort;
import br.com.rompi.cliente.application.ports.out.UpdateClientOutputPort;

public class UpdateClientUseCase implements UpdateClientInputPort {

    private final FindClientByIdInputPort findClientByIdtInputPort;
    private final FindAddressByCepOututPort findAddressByCepOututPort;
    private final UpdateClientOutputPort updateClientOutputPort;

    public UpdateClientUseCase(FindClientByIdInputPort findClientByIdtInputPort,
                               FindAddressByCepOututPort findAddressByCepOututPort,
                               UpdateClientOutputPort updateClientOutputPort) {
        this.findClientByIdtInputPort = findClientByIdtInputPort;
        this.findAddressByCepOututPort = findAddressByCepOututPort;
        this.updateClientOutputPort = updateClientOutputPort;
    }

    @Override
    public Client execute (Client client, String cep){
        findClientByIdtInputPort.execute(client.getId());
        client.setAddress(findAddressByCepOututPort.execute(cep));
        return updateClientOutputPort.execute(client);
    }

}
