package br.com.rompi.cliente.config;

import br.com.rompi.cliente.adapters.out.FindClientAllAdapter;
import br.com.rompi.cliente.adapters.out.FindClientByIdAdapter;
import br.com.rompi.cliente.application.core.usecase.FindClientAllUseCase;
import br.com.rompi.cliente.application.core.usecase.FindClientByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindClientConfig {

    @Bean
    public FindClientByIdUseCase findClientByIdUseCase(FindClientByIdAdapter findClientByIdAdapter){
        return new FindClientByIdUseCase(findClientByIdAdapter);
    }

    @Bean
    public FindClientAllUseCase findClientAllUseCase(FindClientAllAdapter findClientAllAdapter){
        return new FindClientAllUseCase(findClientAllAdapter);
    }
}
