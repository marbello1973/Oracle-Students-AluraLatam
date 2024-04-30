package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=c998aa21";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraMenu() {
        System.out.println("Escibe la serie a buscar");
        String nombreSerie = scanner.nextLine();
        String json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = convierteDatos.obtenerDatos(json, DatosSerie.class);
        System.out.println("Datos: " + datos);

        List<DatosTemporadas> datosTemporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            var temporadas = convierteDatos.obtenerDatos(json, DatosTemporadas.class);
            datosTemporadas.add(temporadas);
        }
        //datosTemporadas.forEach(System.out::println);

        //sin lambas
        System.out.println("SIN LAMBDAS");
        for (int i = 0; i < datos.totalDeTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = datosTemporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }

        //con lambas
        System.out.println("CON LAMBDAS");
        datosTemporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir todas las informciones a una lista del tip DatoEpisodio
        List<DatosEpisodio> datosEpisodios = datosTemporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        //top 5 episodios
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("primer filtro N/A" + e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("segundo filtro ordenacion m > m" + e))
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("tercer filtro convertir mayusculas" + e))
                .limit(5)
                .forEach(System.out::println);

        //convirtiendo los datos a una lista de tipo episodio
        List<Episodio> episodios = datosTemporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        //busqueda de episodios x fechas
        System.out.println("Indica de que año desa ver los episodios");
        var fecha = scanner.nextInt();
        scanner.nextLine();
        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        //formatear la fecha
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                ", Episodio: " + e.getTitulo() +
                                ", Fecha de lanzamiento: " + e.getFechaDeLanzamiento().format(dateTimeFormatter)
                ));

        //busqueda episodios por conincidencia
        System.out.println("Indica titulo del episodio");
        var pedazoTitulo = scanner.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()) {
            System.out.println("Eisodio Encontrado");
            System.out.println("Datos: " + episodioBuscado.get());
        }else{
            System.out.println("episodio no encontrado");
        }

        Map<Integer, Double> evaluacionesPorTemporadas = episodios.stream()
                .filter(e -> e.getEvaluacion() != 0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println("Evaluaciones: " + evaluacionesPorTemporadas);

        //estadisticas de la serie
        DoubleSummaryStatistics estadistica = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media de las evaluaciones: " + estadistica.getAverage());
        System.out.println("Episodio mejor evaluado: " + estadistica.getMax());
        System.out.println("Episodio peor evaluado: " + estadistica.getMin());
        System.out.println("cantidad: " + estadistica.getCount());
    }

    //metodo para imprimir por template html
    @Bean
    public DoubleSummaryStatistics calcularEstadisticas(){
        String nombreSerie = scanner.nextLine();
        String json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = convierteDatos.obtenerDatos(json, DatosSerie.class);

        List<DatosTemporadas> datosTemporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            var temporadas = convierteDatos.obtenerDatos(json, DatosTemporadas.class);
            datosTemporadas.add(temporadas);
        }

        //Convertir todas las informciones a una lista del tip DatoEpisodio
        List<DatosEpisodio> datosEpisodios = datosTemporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        //convirtiendo los datos a una lista de tipo episodio
        List<Episodio> episodios = datosTemporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        DoubleSummaryStatistics std = episodios.stream()
                .filter(e-> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        return std;
    }

}
