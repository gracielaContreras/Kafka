package com.example.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
public class KafkaApplication  implements ApplicationRunner {
	@Autowired
	private KafkaTemplate<String, String> getKafkaTemplate;
	@Autowired
	private ObjectMapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	/**
	 * 1° forma Producer
	 * Se recibe la plantilla kafka y se envía mensaje
	 */
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("amigoscode", "hello kafka");
		};
	}

	/**
	 * 2° forma Producer
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			/**
			 * Utilizando el producer.
			 * El siguiente código publicará un mensaje en el topic "amigoscode"
			 */
			getKafkaTemplate.send(
					"amigoscode",  // Nombre del topic creado
					mapper.writeValueAsString("hola bienvenidoss")); // se convierte de Objeto a String

		} catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error parsing the message");
		}
	}
}
