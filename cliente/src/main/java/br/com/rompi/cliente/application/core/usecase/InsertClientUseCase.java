package br.com.rompi.cliente.application.core.usecase;

import br.com.rompi.cliente.application.core.domain.Address;
import br.com.rompi.cliente.application.core.domain.Client;
import br.com.rompi.cliente.application.ports.in.InsertClientInputPort;
import br.com.rompi.cliente.application.ports.out.FindAddressByCepOututPort;
import br.com.rompi.cliente.application.ports.out.InsertClientOutputPort;

public class InsertClientUseCase implements InsertClientInputPort {

    private final FindAddressByCepOututPort findAddressByCepOututPort;
    private final InsertClientOutputPort insertClientOutputPort;

    public InsertClientUseCase(FindAddressByCepOututPort findAddressByCepOututPort, InsertClientOutputPort insertClientOutputPort) {
        this.findAddressByCepOututPort = findAddressByCepOututPort;
        this.insertClientOutputPort = insertClientOutputPort;
    }

    @Override
    public Client execute (Client client, String cep){
        Address address = findAddressByCepOututPort.execute(cep);
        client.setAddress(address);
        return insertClientOutputPort.execute(client);
    }
}