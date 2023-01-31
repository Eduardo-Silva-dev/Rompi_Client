package br.com.rompi.cliente.application.ports.in;

import br.com.rompi.cliente.application.core.domain.Client;

public interface InsertClientInputPort {

    Client execute(Client client, String cep);
}
