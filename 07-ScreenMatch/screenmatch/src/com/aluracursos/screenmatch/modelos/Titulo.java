package com.aluracursos.screenmatch.modelos;
public class Titulo {

    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnPlan;
    private double sumaDelasEvaluaciones;
    private int totalDelasEvaluaciones;

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

}
