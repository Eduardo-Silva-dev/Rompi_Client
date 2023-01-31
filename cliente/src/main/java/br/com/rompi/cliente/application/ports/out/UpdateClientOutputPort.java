package br.com.rompi.cliente.application.ports.out;

import br.com.rompi.cliente.application.core.domain.Client;

public interface UpdateClientOutputPort {
    Client execute(Client client);
}
