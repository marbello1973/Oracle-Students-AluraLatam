package com.literalura.modelos;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne()
    @JoinColumn( name = "autor_id", nullable = false)
    private Autor autor;
    private List<String> temas;
    @Enumerated(EnumType.STRING)
    private Lenguaje lenguaje;
    private String derechos_autor;
    private String tipo_de_medio;
    private Long contador_descargas;

    public Libro() {
    }

    public Libro(LibroResults libroResults) {
       // this.id = libroResults.id();
        this.titulo = libroResults.titulo();
        this.temas = libroResults.temas();
        this.lenguaje = libroResults.lenguaje().isEmpty() ? null : Lenguaje.desdeCodigo(libroResults.lenguaje().get(0).toUpperCase());
        this.derechos_autor = libroResults.derechos_autor();
        this.tipo_de_medio = libroResults.tipo_de_medio();
        this.contador_descargas = libroResults.contador_descargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getDerechos_autor() {
        return derechos_autor;
    }

    public void setDerechos_autor(String derechos_autor) {
        this.derechos_autor = derechos_autor;
    }

    public String getTipo_de_medio() {
        return tipo_de_medio;
    }

    public void setTipo_de_medio(String tipo_de_medio) {
        this.tipo_de_medio = tipo_de_medio;
    }

    public Long getContador_descargas() {
        return contador_descargas;
    }

    public void setContador_descargas(Long contador_descargas) {
        this.contador_descargas = contador_descargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", temas=" + temas +
                ", lenguaje=" + lenguaje +
                ", derechos_autor='" + derechos_autor + '\'' +
                ", tipo_de_medio='" + tipo_de_medio + '\'' +
                ", contador_descargas=" + contador_descargas +
                '}';
    }
}
