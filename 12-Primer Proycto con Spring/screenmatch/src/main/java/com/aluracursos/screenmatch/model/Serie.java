package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private Integer totalDeTemporadas;
    private Double evaluacion;
    private String añoPublicacion;
    private String clasificacion;
    private String fechaDelanzamiento;
    private String duracion;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String director;
    private String escritor;
    private String actores;
    private String sinopsis;
    private String idioma;
    private String pais;
    private String premios;
    private String poster;
    private String tipo;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios;

    public Serie(){}

    public Serie(DatosSerie datosSerie){
        this.titulo = datosSerie.titulo();
        this.totalDeTemporadas = datosSerie.totalDeTemporadas();
        this.evaluacion = OptionalDouble.of(Double.valueOf(datosSerie.evaluacion())).orElse(0);
        this.clasificacion = datosSerie.clasificacion();
        this.fechaDelanzamiento = datosSerie.fechaDelanzamiento();
        this.duracion = datosSerie.duracion();
        this.genero = Categoria.fromString(datosSerie.genero().split(",")[0].trim());
        this.director = datosSerie.director();
        this.escritor = datosSerie.escritor();
        this.actores = datosSerie.actores();
        //this.sinopsis = ConsultaChatGPT.obtenerTraduccion(datosSerie.sinopsis()); //error 429 sin creditos en OpenAi-ChatGPT
        this.sinopsis = datosSerie.sinopsis();
        this.idioma = datosSerie.idioma();
        this.pais = datosSerie.pais();
        this.premios = datosSerie.premios();
        this.poster = datosSerie.poster();
        this.tipo = datosSerie.tipo();
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

    public Integer getTotalDeTemporadas() {
        return totalDeTemporadas;
    }

    public void setTotalDeTemporadas(Integer totalDeTemporadas) {
        this.totalDeTemporadas = totalDeTemporadas;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFechaDelanzamiento() {
        return fechaDelanzamiento;
    }

    public void setFechaDelanzamiento(String fechaDelanzamiento) {
        this.fechaDelanzamiento = fechaDelanzamiento;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        episodios.forEach(e -> e.setSerie(this));
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", totalDeTemporadas=" + totalDeTemporadas +
                ", evaluacion='" + evaluacion + '\'' +
                ", añoPublicacion='" + añoPublicacion + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", fechaDelanzamiento='" + fechaDelanzamiento + '\'' +
                ", duracion='" + duracion + '\'' +
                ", genero=" + genero +
                ", director='" + director + '\'' +
                ", escritor='" + escritor + '\'' +
                ", actores='" + actores + '\'' +
                ", trama='" + sinopsis + '\'' +
                ", idioma='" + idioma + '\'' +
                ", pais='" + pais + '\'' +
                ", premios='" + premios + '\'' +
                ", poster='" + poster + '\'' +
                ", tipo='" + tipo + '\'' +
                ", episodios='" + episodios + '\'';
    }
}
