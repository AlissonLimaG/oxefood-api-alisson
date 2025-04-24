package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //Anotação para fazer as anotações de auditoria funcionarem 'CreatedDate, LastModifiyedDate'
public class OxefoodApiAlissonApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiAlissonApplication.class, args);
	}

}
