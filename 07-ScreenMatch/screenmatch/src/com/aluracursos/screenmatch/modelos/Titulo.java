package com.aluracursos.screenmatch.modelos;

public class Titulo implements Comparable<Titulo> {


    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnPlan;
    private double sumaDelasEvaluaciones;
    private int totalDelasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmdb.year());
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ", ""));
    }


    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnPlan() {
        return incluidoEnPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnPlan(boolean incluidoEnPlan) {
        this.incluidoEnPlan = incluidoEnPlan;
    }

    public void muestraFichaTecnica(){
        System.out.println(nombre);
        System.out.println(fechaDeLanzamiento);
        System.out.println(getDuracionEnMinutos());
    }

    public void evalua(double nota){
        sumaDelasEvaluaciones += nota;
        totalDelasEvaluaciones++;
    }

    public double calcularMedia(){
        return sumaDelasEvaluaciones / totalDelasEvaluaciones;
    }


    public double getSumaDelasEvaluaciones(){
        return sumaDelasEvaluaciones;
    }


    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre: " + nombre +
                ", fechaDeLanzamiento: " + fechaDeLanzamiento +
                ", duracion: " + duracionEnMinutos + ")";

    }
}
