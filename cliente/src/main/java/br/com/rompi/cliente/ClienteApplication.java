package br.com.rompi.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
public class ClienteApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
}
