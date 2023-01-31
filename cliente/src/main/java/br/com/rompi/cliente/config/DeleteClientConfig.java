package br.com.rompi.cliente.config;

import br.com.rompi.cliente.adapters.out.DeleteClientAdapter;
import br.com.rompi.cliente.application.core.usecase.DeleteClientUseCase;
import br.com.rompi.cliente.application.ports.in.FindClientByIdInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteClientConfig {

    @Bean
    public DeleteClientUseCase deleteClientUseCase(FindClientByIdInputPort findClientByIdtInputPort,
                                                   DeleteClientAdapter deleteClientAdapter){
        return new DeleteClientUseCase(findClientByIdtInputPort, deleteClientAdapter);
    }
}
