package com.aluracursos.screenmatch.caculos;

public class FiltroRecomendacion {

    public void filtra(Clasificacion clasificacion){
        if(clasificacion.getClasificacion() >= 4){
            System.out.println("Muy Bien Evaluada *****");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("popular en el momento");
        }else {
            System.out.println("Guardar para ver despues");
        }
    }
}
