package com.literalura.principal;

import com.literalura.consumoapi.ConsumoApi;
import com.literalura.modelos.*;
import com.literalura.repository.AutorRepository;
import com.literalura.repository.LibroRepository;
import com.literalura.servicio.ConvertirDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Principal {
    private final String url = "https://gutendex.com/books/";

    //repositorios y servicios
    private LibroRepository libroRepositorio;
    private AutorRepository autorRepository;
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private ConsumoApi consumoApi = new ConsumoApi();


   /* @Autowired
    public Principal(
            LibroRepository libroRepository,
            AutorRepository autorRepository,
            ConvertirDatos convertirDatos,
            ConsumoApi consumoApi
    ){
        this.libroRepositorio = libroRepositorio;
        this.autorRepository = autorRepository;
        this.convertirDatos = convertirDatos;
        this.consumoApi = consumoApi;
    }

    public Principal() {
        this.libroRepositorio = null;
        this.autorRepository = null;
        this.convertirDatos = null;
        this.consumoApi = null;
    }*/

    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepositorio = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void mostarEnApp(){
        buscarLibrosGuardarEnbaseDatos();
        //obtenerDatosLibros();
    }

    private LibroResults obtenerDatosLibros() {
        // Obtener los datos de la API y convertirlos en un objeto LibroResults
        var json = consumoApi.obtenerDatosApi("https://gutendex.com/books/");
        LibroResults datos = convertirDatos.obtenerDatos(json, LibroResults.class);
        return datos;
    }

    private void buscarLibrosGuardarEnbaseDatos(){
        List<LibroRecord> libros = obtenerDatosLibros().libroRecords();
        for (LibroRecord libroRecord : libros) {
            // Verificar si el libro ya existe en la base de datos
            Libro existingLibro = libroRepositorio.findByTitulo(libroRecord.titulo());
            if (existingLibro != null) {
                // Si el libro ya existe, podrías actualizar los datos aquí si es necesario
                System.out.println("El libro con título '" + libroRecord.titulo() + "' ya existe en la base de datos.");
                // Aquí podrías actualizar los datos del libro existente si es necesario
            } else {
                // Si el libro no existe, procede con la inserción
                Libro libro = new Libro(libros);
                libro.setId(libroRecord.id());
                libro.setTitulo(libroRecord.titulo());
                libro.setTemas(libroRecord.temas());
                libro.setLenguajes(libroRecord.lenguajes());
                libro.setDerechos_de_autor(libroRecord.derechos_de_autor());
                libro.setTipo_de_medio(libroRecord.tipo_de_medio());
                libro.setContador_de_descargas(libroRecord.contador_de_descargas());

                // Guardar el libro en la base de datos
                libroRepositorio.save(libro);
                System.out.println("LIBRO SAVED: --> " + libro);
            }
        }
    }

    private void buscarAutorGuardarEnbaseDatos(){


    }
}

/*List<LibroRecord> autor = obtenerDatosLibros().libroRecords().stream()
                            .filter(l -> !l.autor().isEmpty())
                    .collect(Collectors.toList());

            List<Autor> autores = obtenerDatosLibros().libroRecords().stream()
                            .flatMap(l -> l.autor().stream()
                                    .map(a -> new Autor(
                                            a.getNombre(),
                                            a.getAno_de_nacimiento(),
                                            a.getAno_de_muerte()
                                    )))
                    .collect(Collectors.toList()).reversed();*/




