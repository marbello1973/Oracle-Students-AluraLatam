package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.*;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ConsumoApi;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.context.annotation.Configuration;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=c998aa21";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private List<DatosSerie> datosSeries = new ArrayList<>();
    private List<Serie> series = new ArrayList<>();
    private SerieRepository serieRepository;
    private Optional<Serie> serieBuscada;
    public Principal(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void muestraMenu() {

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar serie
                    2 - Buscar epsidosios
                    3 - Mostrar series buscadas
                    4 - Buscar serie por titulo
                    5 - Top 5 mejores series 
                    6 - Ordenar por duracion en minutos
                    7 - Buscar series por categoria
                    8 - Filtrar series
                    9 - Buscar episodios por tiutlo
                    10- Top 5 episodio por serie
                                        
                    0 - Salir 
                    """;
            System.out.println(menu);

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarPorDuracion();
                    break;
                case 7:
                    buscarSeriePorGeneroCategoria();
                    break;
                case 8:
                    filtrarSeriesPorTemporadasEvaluaciones();
                    break;
                case 9:
                    buscarEpisodiosPorTitulo();
                    break;
                case 10:
                    buscarTop5Episodios();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicacion...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;

            }
        }
    }

    private void buscarSerieWeb(){
        DatosSerie datos = getDatosSerie();
        Serie serie = new Serie(datos);
        //datosSeries.add(datos);
        serieRepository.save(serie);
        System.out.println(datos);
    }

    private DatosSerie getDatosSerie(){
        System.out.println("Escriba el nombre de la serie que deseas buscar");
        var nombreSerie = scanner.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        DatosSerie datos = convierteDatos.obtenerDatos(json, DatosSerie.class);
        return datos;
    }

    private void buscarEpisodioPorSerie(){
        mostrarSeriesBuscadas();
        System.out.println("Escriba los episodios a buscar");
        var nombreSerie = scanner.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();

        if(serie.isPresent()){
            var serieEncontrada = serie.get();
            List<DatosTemporadas> temporadas = new ArrayList<>();
            for (int i = 1; i < serieEncontrada.getTotalDeTemporadas(); i++) {
                var json = consumoApi.obtenerDatos(URL_BASE + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DatosTemporadas datosTemporadas = convierteDatos.obtenerDatos(json, DatosTemporadas.class);
                temporadas.add(datosTemporadas);
            }
            temporadas.forEach(System.out::println);

            List<Episodio> episodio = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                            .collect(Collectors.toList());

            serieEncontrada.setEpisodios(episodio);
            serieRepository.save(serieEncontrada);
        }
    }

    private void mostrarSeriesBuscadas() {
        series = serieRepository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private void buscarSeriePorTitulo() {
        System.out.println("Escriba la serie a buscar");
        var nombreSerie = scanner.nextLine();
        serieBuscada = serieRepository.findByTituloContainsIgnoreCase(nombreSerie);
        try{
            if(serieBuscada.isPresent()){
                System.out.println("La serie encontrada es: " + serieBuscada.get());
            }else {
                System.out.println("Serie no encontrada");
            }
        }catch(InputMismatchException ex){
            System.out.println("Serie no existe en base de datos");
        }
    }

    private void buscarTop5Series(){
        System.out.println("Buscar top 5 series");
        List<Serie> topCincoMejoresSeries = serieRepository.findTop5ByOrderByEvaluacionDesc();
        topCincoMejoresSeries.forEach(s -> {
            System.out.println("Serie: " + s.getTitulo() + " - " + "Evaluacion: " + s.getEvaluacion());
        });
    }

    private void buscarPorDuracion(){
        System.out.println("Ordenar por duracion");
        List<Serie> duracion = serieRepository.findByOrderByDuracionDesc();
        duracion.forEach(d -> {
            System.out.println("Serie: " + d.getTitulo() + " -- " + "Duracion: " + d.getDuracion());
        });
    }

    private void buscarSeriePorGeneroCategoria(){
        try{
            System.out.println("Buscar serie por categoria / genero");
            var genero = scanner.nextLine();
            var categoria = Categoria.fromEspañol(genero);
            List<Serie> seriesPorCategoria = serieRepository.findByGenero(categoria);
            System.out.println("Las series con esta categoria: " + genero);
            seriesPorCategoria.forEach(s -> {
                System.out.println("Nombre Serie: " + s.getTitulo() + " -- " + "Genero: " + s.getGenero());
            });
        }catch(IllegalArgumentException ex){
            System.out.println("not found serie");
        }
    }

    private void filtrarSeriesPorTemporadasEvaluaciones(){
        System.out.println("Filtrar serie con cuantas temporadas");
        var totalTemporadas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Valor de la evaluacion ");
        var evaluacion = scanner.nextDouble();
        scanner.nextLine();
        List<Serie> serieFiltrada = serieRepository.seriesPorTemporadasyEvaluacion(totalTemporadas, evaluacion);
        System.out.println("SERIE FILTRADA");
        serieFiltrada.forEach( s -> System.out.println(s.getTitulo() + " - evaluacion: " + s.getEvaluacion()));
    }

    private void buscarEpisodiosPorTitulo(){
        System.out.println("Escribe el nombre del episodios a buscar");
        var nombreEpisodio = scanner.nextLine();
        List<Episodio> episodiosEncontrados = serieRepository.episodiosPorNombre(nombreEpisodio);
        episodiosEncontrados.forEach(e -> {
            System.out.println(
                    "Serie: " + e.getSerie().getTitulo() + " -- " +
                    "Temporada: " + e.getTemporada() + " -- " +
                    "Episodio: " + e.getNumeroEpisodio() + " -- " +
                    "Evaluacion: " +e.getEvaluacion());
        });
    }

    private void buscarTop5Episodios(){
        buscarSeriePorTitulo();
        if(serieBuscada.isPresent()){
            Serie serie = serieBuscada.get();
            List<Episodio> topEpisodios = serieRepository.top5Episodios(serie);
            topEpisodios.forEach( e -> System.out.printf("Serie: %s - Temporada: %s - Episodio: %s - Evaluacion: %s \n",
                    e.getSerie().getTitulo(), e.getTemporada(), e.getTitulo(), e.getEvaluacion()));
        }
    }

    /*private void filtrarSeriesPorTemporadasEvaluaciones(){
        System.out.println("Filtrar serie con cuantas temporadas");
        var totalTemporadas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Valor de la evaluacion ");
        var evaluacion = scanner.nextDouble();
        scanner.nextLine();
        List<Serie> serieFiltrada = serieRepository.findByTotalDeTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(totalTemporadas, evaluacion);
        System.out.println("SERIE FILTRADA");
        serieFiltrada.forEach( s -> System.out.println(s.getTitulo() + " - evaluacion: " + s.getEvaluacion()));
    }*/
}