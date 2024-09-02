package pl.dom.KafkaMQ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMqApplication.class, args);
	}
	
}
