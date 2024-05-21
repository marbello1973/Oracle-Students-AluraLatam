package com.literalura;
import com.literalura.principal.Principal;
import com.literalura.repositorio.AutorRepositorio;
import com.literalura.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.literalura")
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private LibroRepositorio libroRepositorio;
	@Autowired
	private AutorRepositorio autorRepositorio;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepositorio, autorRepositorio);
		principal.mostarEnApp();

	}
}
