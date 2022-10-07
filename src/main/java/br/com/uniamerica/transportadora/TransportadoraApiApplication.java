package br.com.uniamerica.transportadora;

import br.com.uniamerica.transportadora.Repository.CaminhaoRepository;
import br.com.uniamerica.transportadora.Service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportadoraApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransportadoraApiApplication.class, args);
	}

}
