package br.com.rompi.cliente.config;

import br.com.rompi.cliente.adapters.out.FindAddressByCepAdapter;
import br.com.rompi.cliente.adapters.out.InsertClientAdapter;
import br.com.rompi.cliente.application.core.usecase.InsertClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertClientConfig {

    @Bean
    public InsertClientUseCase insertClientUseCase(
            FindAddressByCepAdapter findAddressByCepAdapter,
            InsertClientAdapter insertClientAdapter){

        return new InsertClientUseCase(findAddressByCepAdapter, insertClientAdapter);
    }
}
