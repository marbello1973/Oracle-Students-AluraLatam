package com.literalura.modelos;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private int ano_de_nacimiento;
    private int ano_de_muerte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;

    public Autor(Long id, String nombre, int ano_de_nacimiento, int ano_de_muerte, List<Libro> libro) {
        this.id = id;
        this.nombre = nombre;
        this.ano_de_nacimiento = ano_de_nacimiento;
        this.ano_de_muerte = ano_de_muerte;
        this.libro = libro;
    }

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAno_de_nacimiento() {
        return ano_de_nacimiento;
    }

    public void setAno_de_nacimiento(int ano_de_nacimiento) {
        this.ano_de_nacimiento = ano_de_nacimiento;
    }

    public int getAno_de_muerte() {
        return ano_de_muerte;
    }

    public void setAno_de_muerte(int ano_de_muerte) {
        this.ano_de_muerte = ano_de_muerte;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }
}
