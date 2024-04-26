package com.conversor.menu;

import com.conversor.http.HttpPeticionApi;
import com.conversor.modelos.MonedasRecord;
import java.util.Map;

public class MostrarMenu {

   public static  void mostrarMenu(){

       HttpPeticionApi http = new HttpPeticionApi();
       MonedasRecord monedasRecord = http.realizarPeticionApi("USD");

       Map<String, Double> conversionrates = monedasRecord.conversion_rates();

       StringBuilder inicial = new StringBuilder();
       int contador = 0;

       for (String key: conversionrates.keySet()){
           String initial = key.replaceAll("[^a-zA-Z]", "");
           if(!initial.isEmpty()){
               inicial.append(initial).append(" ");
               contador++;
           }
           if(contador > 30) break;
       }

       // Mostrar las iniciales en filas de 10 caracteres
       System.out.println("===============================================");
       System.out.println("       ELIJA LAS MONEDAS A COVERTIR");
       System.out.println("===============================================");

       int largoDeFila = 45;
       int length = inicial.length();
       for (int i = 0; i < length; i += largoDeFila) {
           int end = Math.min(i + largoDeFila, length);
           System.out.println(inicial.substring(i, end));
       }
       System.out.println("===============================================");
       System.out.println("1. CONVERTIR MONEDA");
       System.out.println("2. SALIR");
       System.out.println("===============================================");
       
   }
}
