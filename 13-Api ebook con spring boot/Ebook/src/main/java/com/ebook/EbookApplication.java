package com.ebook;

import com.ebook.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EbookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EbookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.datosDeConsulta();
	}
}
