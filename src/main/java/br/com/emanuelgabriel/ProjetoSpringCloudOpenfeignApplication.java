package br.com.emanuelgabriel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjetoSpringCloudOpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringCloudOpenfeignApplication.class, args);
	}

}
