package br.com.rompi.cliente.application.ports.in;

import br.com.rompi.cliente.application.core.domain.Client;

import java.util.List;

public interface FindClientAllInputPort {

    List<Client> execute();
}
