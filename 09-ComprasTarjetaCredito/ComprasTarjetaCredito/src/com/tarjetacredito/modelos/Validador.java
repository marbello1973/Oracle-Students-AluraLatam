package com.tarjetacredito.modelos;

import java.util.Scanner;

public class Validador {
    public double nuevoCupo = 0;
    boolean entradaValida = false;

    public void validarEntradaNumerica(double numero){
        Scanner sc = new Scanner(System.in);
        while(!entradaValida){
            if(sc.hasNextDouble()){
                nuevoCupo = sc.nextDouble();
                entradaValida = true;
            }else {
                System.out.println("¡Error Ingrese un valor numerico valido. ");
                sc.next();
            }
        }

    }

}
