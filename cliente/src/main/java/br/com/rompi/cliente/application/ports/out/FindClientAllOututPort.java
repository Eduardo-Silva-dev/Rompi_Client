package br.com.rompi.cliente.application.ports.out;

import br.com.rompi.cliente.application.core.domain.Client;

import java.util.List;

public interface FindClientAllOututPort {

    List<Client> execute();
}
