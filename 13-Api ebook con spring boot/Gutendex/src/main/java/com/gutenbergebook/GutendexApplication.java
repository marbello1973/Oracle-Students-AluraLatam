package com.gutenbergebook;

import com.gutenbergebook.modelo.DatosGutendex;
import com.gutenbergebook.modelo.DatosResults;
import com.gutenbergebook.service.ConsultaApi;
import com.gutenbergebook.service.ConvertidorDeDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GutendexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GutendexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consultaApi = new ConsultaApi();
		var json = consultaApi.obtenerDatosApi("https://gutendex.com/books/");
		ConvertidorDeDatos conversor = new ConvertidorDeDatos();
		var datos = conversor.obtenerDatosApi(json, DatosGutendex.class);
		System.out.println(datos);

		json = consultaApi.obtenerDatosApi("https://gutendex.com/books/1");
		DatosResults datosResults = conversor.obtenerDatosApi(json, DatosResults.class);
		System.out.println(datosResults);





	}
}
