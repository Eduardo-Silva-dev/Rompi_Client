package br.com.rompi.cliente.application.ports.in;

import br.com.rompi.cliente.application.core.domain.Client;

import java.util.Optional;

public interface FindClientByIdInputPort {

    Optional<Client> execute(long id);
}
