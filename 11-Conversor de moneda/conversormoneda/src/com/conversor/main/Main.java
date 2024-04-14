package com.conversor.main;

import com.conversor.calculos.ConversorMonedas;
import com.conversor.http.HttpPeticionApi;
import com.conversor.menu.MostrarMenu;
import com.conversor.modelos.MonedasRecord;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HttpPeticionApi http = new HttpPeticionApi();
        ConversorMonedas conversor = new ConversorMonedas();

        boolean salir = false;
        int opcion;
        while(!salir){
            MostrarMenu.mostrarMenu();
            try{
                System.out.println("Elija una opcion");
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese moneda inicial:");
                        String monedaInicial = scanner.next().toUpperCase();
                        System.out.println("Ingrese moneda destino:");
                        String monedaDestino = scanner.next().toUpperCase();
                        System.out.println("Ingrese la cantidad a convertir:");
                        double cantidad = scanner.nextDouble();
                        MonedasRecord moneda = http.realizarPeticionApi(monedaInicial);
                        if(moneda != null){
                            double resultado = conversor.convertirMoneda(cantidad, moneda, monedaDestino);
                            System.out.println("Resultado de convertir: " + monedaInicial + " a " + monedaDestino + " es " + resultado);
                            System.out.println("¿Desea realizar otra conversion..? SI/NO ");
                            String respuesta = scanner.next().toUpperCase();
                            if(!respuesta.equals("SI")){
                                salir = true;
                            }
                        }else {
                            System.out.println("Moneda inicial no es valida");
                        }
                        break;
                    case 2:
                        System.out.println("Saliendo del programa ");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion no valida. POr favor, elija una opcion del menu");
                }
            }catch(InputMismatchException ex){
                System.out.println("Debe insertar un numero");
                scanner.next();
            }
        }
    }
}
