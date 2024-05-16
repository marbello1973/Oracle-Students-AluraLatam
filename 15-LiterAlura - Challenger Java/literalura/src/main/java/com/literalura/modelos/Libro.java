package com.literalura.modelos;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private List<Autor> autor;
    private List<String> temas;
    private List<String> lenguajes;
    private Boolean derechos_de_autor;
    private String tipo_de_medio;
    private Long contador_de_descargas;

    public Libro(Long id, String titulo, List<Autor> autor, List<String> temas, List<String> lenguajes, Boolean derechos_de_autor, String tipo_de_medio, Long contador_de_descargas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.temas = temas;
        this.lenguajes = lenguajes;
        this.derechos_de_autor = derechos_de_autor;
        this.tipo_de_medio = tipo_de_medio;
        this.contador_de_descargas = contador_de_descargas;
    }

    public Libro() {
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        autor.forEach(a -> a.setLibro((List<Libro>) this));
        this.autor = autor;
    }

    public Libro(List<LibroRecord> datos) {
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

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Boolean getDerechos_de_autor() {
        return derechos_de_autor;
    }

    public void setDerechos_de_autor(Boolean derechos_de_autor) {
        this.derechos_de_autor = derechos_de_autor;
    }

    public String getTipo_de_medio() {
        return tipo_de_medio;
    }

    public void setTipo_de_medio(String tipo_de_medio) {
        this.tipo_de_medio = tipo_de_medio;
    }

    public Long getContador_de_descargas() {
        return contador_de_descargas;
    }

    public void setContador_de_descargas(Long contador_de_descargas) {
        this.contador_de_descargas = contador_de_descargas;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", temas=" + temas +
                ", lenguajes=" + lenguajes +
                ", derechos_de_autor=" + derechos_de_autor +
                ", tipo_de_medio='" + tipo_de_medio + '\'' +
                ", contador_de_descargas=" + contador_de_descargas;

    }
}
