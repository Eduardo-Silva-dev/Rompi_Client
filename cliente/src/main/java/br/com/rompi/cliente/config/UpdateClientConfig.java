package br.com.rompi.cliente.config;

import br.com.rompi.cliente.adapters.out.FindAddressByCepAdapter;
import br.com.rompi.cliente.adapters.out.UpdateClientAdapter;
import br.com.rompi.cliente.application.core.usecase.UpdateClientUseCase;
import br.com.rompi.cliente.application.ports.in.FindClientByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateClientConfig {

    @Bean
    public UpdateClientUseCase updateClientUseCase(
            FindClientByIdInputPort findClientByIdtInputPort,
            FindAddressByCepAdapter findAddressByCepAdapter,
            UpdateClientAdapter updateClientAdapter
    ){

        return new UpdateClientUseCase(findClientByIdtInputPort,findAddressByCepAdapter,updateClientAdapter);
    }
}
