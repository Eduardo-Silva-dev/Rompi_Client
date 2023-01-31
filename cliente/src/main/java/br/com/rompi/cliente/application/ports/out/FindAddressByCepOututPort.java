package br.com.rompi.cliente.application.ports.out;

import br.com.rompi.cliente.application.core.domain.Address;

public interface FindAddressByCepOututPort {

    Address execute(String cep);
}
