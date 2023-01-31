package br.com.rompi.cliente.application.ports.out;

import br.com.rompi.cliente.application.core.domain.Client;

import java.util.Optional;

public interface FindClientByIdOututPort {

    Optional<Client> execute(long id);
}
