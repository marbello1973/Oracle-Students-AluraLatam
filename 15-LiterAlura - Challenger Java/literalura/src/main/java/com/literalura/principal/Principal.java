package com.literalura.principal;

import com.literalura.consumoapi.ConsumoApi;
import com.literalura.dto.AutorDTO;
import com.literalura.modelos.*;
import com.literalura.repositorio.AutorRepositorio;
import com.literalura.repositorio.LibroRepositorio;
import com.literalura.servicio.ConvertirDatos;

import java.util.*;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    private final String url = "https://gutendex.com/books/";
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private ConsumoApi consumoApi = new ConsumoApi();
    private LibroRepositorio libroRepositorio;
    private AutorRepositorio autorRepositorio;
    private Autor autor = new Autor();
    private List<Libro> libroList = new ArrayList<>();
    public Principal(LibroRepositorio libroRepositorio, AutorRepositorio autorRepositorio){
        this.libroRepositorio = libroRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void mostarEnApp(){
       var opcion = -1;
       while (opcion != 0){
           var menu = """
                   ==============================================================================
                   
                   1 - Registrar libro en base de datos
                   2 - Mostrar libros registrados
                   3 - Mostrar lista de autores registrados
                   4 - Mostrar autores vivos en determinado año
                   5 - Buscar libro por idioma
                   
                   0 - Salir
                   
                   ==============================================================================
                   """;

           System.out.println(menu);
           opcion = scanner.nextInt();
           scanner.nextLine();
           switch (opcion){
               case 1:
                   obtenerDatosLibros();
                   break;
               case 2:
                   mostrarLibrosEnBaseDatos();
                   break;
               case 3:
                   mostrarAutoresRegistrados();
                   break;
               case 4:
                   mostrarAutoresVivosEnAño();
                   break;
               case 5:
                   buscarLibrosLenguaje();
                   break;
               case 0:
                   System.out.println("Cerrando aplicacion...");
                   break;
               default:
                   System.out.println("Opcion invalida");
                   break;
           }
       }
    }

    private void obtenerDatosLibros() {
        System.out.println("-------------------------------------------------");
        System.out.println("Escriba el nombre del libro que desea buscar...");
        String nombreLibro = scanner.nextLine().trim();
        String formated = nombreLibro.replace(" ", "+").toLowerCase();
        String contenido = "{\"count\":0, \"next\":null, \"previous\":null, \"results\":[]}";
        System.out.println("-------------------------------------------------");

        if (nombreLibro.isEmpty()) {
            System.out.println("Nombre del libro no puede estar vacío");
            return;
        }

        try {
            var json = consumoApi.obtenerDatosApi(url + "?search=" + formated);
            if (json.contains(contenido)) {
                System.out.println("No se encontraron resultados...");
            } else {
                convertirDatos.obtenerDatos(json, DatosLibro.class).libro().stream()
                        .findFirst()
                        .ifPresent(datos -> {
                            String titulo = datos.titulo();
                            String nombreAutor = datos.autor().get(0).nombre();

                            Optional<Libro> libroExiste = libroRepositorio.findByTituloAndAutor(titulo, nombreAutor);

                            if (libroExiste.isPresent()) {
                                System.out.println("El libro ya existe con ese autor.");
                                return;
                            }

                            autor = autorRepositorio.findByAutor(nombreAutor)
                                    .orElseGet(() -> autorRepositorio.save(new Autor(datos.autor().get(0))));

                            try {
                                Libro libro = new Libro(datos);
                                libro.setAutor(autor);

                                // Asegurarse de que el autor y el libro se guarden de manera correcta y una sola vez.
                                libroRepositorio.save(libro);
                                autor.getLibros().add(libro);
                                autorRepositorio.save(autor);
                                System.out.println("==============================================================================");
                                System.out.println("Libro guardado exitosamente...\n" +
                                        "----------------------LIBRO----------------------" + '\n' +
                                        "Titulo              : " + cortarTitulo(libro.getTitulo()) + '\n' +
                                        "Autor               : " + autor.getNombre() + '\n' +
                                        "Idioma              : " + libro.getLenguaje() + '\n' +
                                        "Numero de descargas : " + libro.getContador_descargas());
                                //System.out.println("==============================================================================");
                            } catch (Exception ex) {
                                System.out.println("Error al guardar el libro: " + ex.getMessage());
                            }
                        });
            }
        } catch (Exception ex) {
            System.out.println("Error al obtener datos: " + ex.getMessage());
        }
    }
    private void mostrarLibrosEnBaseDatos() {
        libroList = libroRepositorio.findAll();
        libroList.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(libro -> {
                    Autor autorLibro = libro.getAutor();
                    System.out.println(
                            "==============================================================================" + '\n' +
                            "Titulo              : " + cortarTitulo(libro.getTitulo()) + '\n' +
                            "Autor               : " + (autorLibro != null ? autorLibro.getNombre() : "Desconocido") + '\n' +
                            "Idioma              : " + libro.getLenguaje() + '\n' +
                            "Numero de descargas : " + libro.getContador_descargas() + '\n');
                });
    }
    public List<AutorDTO> mostrarAutoresRegistrados() {
        List<Autor> autores = autorRepositorio.findAll();
        List<AutorDTO> autorDTOS = new ArrayList<>();
        for(Autor autor : autores){
            System.out.println(
                    "==============================================================================" + '\n' +
                            "Autor               : " + autor.getNombre() + '\n' +
                            "Fecha nacimiento    : " + autor.getAno_nacimiento() + '\n' +
                            "Fecha fallecimiento : " + autor.getAno_muerte() + '\n');
            System.out.println("Libros: ");
            for(Libro libro : autor.getLibros()){
                System.out.println(" - " + cortarTitulo(libro.getTitulo()));
            }
            AutorDTO autorDTO = new AutorDTO(autor.getNombre(), autor.getAno_nacimiento(), autor.getAno_muerte());
            autorDTOS.add(autorDTO);
        }
        return autorDTOS;
    }
    private void mostrarAutoresVivosEnAño() {

        System.out.println("-------------------------------------------------");
        System.out.println("Ingrese al año a consultar...");
        int anoConsulta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("-------------------------------------------------");

        List<Autor> autores = autorRepositorio.findAll();

        for(Autor autor : autores){
            Integer anoNacimiento = autor.getAno_nacimiento();
            Integer anoMuerte = autor.getAno_muerte();

            if(anoNacimiento != null && anoConsulta >= anoNacimiento && (anoMuerte == null || anoConsulta <= anoMuerte)){
                System.out.println("==============================================================================" + '\n' +
                        "Nombre              : " + autor.getNombre() + '\n' +
                        "Fecha nacimiento    : " + autor.getAno_nacimiento() + '\n' +
                        "Fecha fallecimiento : " + (anoMuerte != null ? anoMuerte : "N/A"));

                if(autor.getLibros() != null && !autor.getLibros().isEmpty()){
                    System.out.println("Libros: ");
                    for(Libro libro : autor.getLibros()){
                        System.out.println(" - Titulo: " + cortarTitulo(libro.getTitulo()));
                    }
                }else{
                    System.out.println("Autor no tienen libros registrados");
                }                
            }
        }
    }

    private void buscarLibrosLenguaje() {
        System.out.println("Ingrese el lenguaje que desea buscar");
        String codigoLenguaje = scanner.nextLine().trim().toLowerCase();
        if(codigoLenguaje.isEmpty()) System.out.println("Lenguaje no puede estar vacio");

        try{
            Lenguaje lenguaje = Lenguaje.desdeCodigo(codigoLenguaje);
            List<Libro> libros = libroRepositorio.findByLenguaje(lenguaje);
            if(libros.isEmpty()){
                System.out.println("No se encontaron libros en el lenguaje: " + lenguaje);
            }else{
                libros.forEach(libro -> {
                    Autor autor = libro.getAutor();
                    System.out.println(
                            "==============================================================================" + '\n' +
                                    "Titulo           : " + libro.getTitulo() + '\n' +
                                    "Autor            : " + (autor != null ? autor.getNombre() : "Desconocido" ) + '\n' +
                                    "Idioma           : " + libro.getLenguaje() + '\n' +
                                    "Numero descargas : " + libro.getContador_descargas());
                });
            }

        }catch(IllegalArgumentException ex){
            System.out.println("Codigo lenguaje no valido: " + codigoLenguaje);
        }
    }

    private String cortarTitulo(String titulo){
        String[] partes = titulo.split(":");
        String tituloCorto = partes[0].trim();
        return tituloCorto;
    }
}




/*clase original sin dto
    private void mostrarAutoresRegistrados() {
        List<Autor> autores = autorRepositorio.findAll();
        for(Autor autor : autores){
            System.out.println(
                    "==============================================================================" + '\n' +
                    "Autor : " + autor.getNombre() + '\n' +
                    "Fecha nacimiento: " + autor.getAno_nacimiento() + '\n' +
                    "Fecha fallecimiento: " + autor.getAno_muerte() + '\n');
            System.out.println("Libros: ");
            for(Libro libro : autor.getLibros()){
                System.out.println(" - " + cortarTitulo(libro.getTitulo()));
            }
        }
    }*/



