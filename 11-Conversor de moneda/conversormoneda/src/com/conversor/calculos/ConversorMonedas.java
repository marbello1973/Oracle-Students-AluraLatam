package com.conversor.calculos;
import com.conversor.modelos.MonedasRecord;
public class ConversorMonedas {
    public double convertirMoneda(double cantidad, MonedasRecord moneda, String monedaDestino){

        try{
            if(moneda.conversion_rates() == null){
                throw new IllegalArgumentException("El mapa es nulo");
            }
            double tasaConversionOrigen = moneda.conversion_rates().getOrDefault(monedaDestino, 0.0);

            if(tasaConversionOrigen == 0.0) {
                throw new IllegalArgumentException("Tasa no encontrada");
            }
            if(!monedaDestino.equals("USD")) tasaConversionOrigen = 1 * tasaConversionOrigen;
            return cantidad * tasaConversionOrigen;

        }catch(NullPointerException | IllegalArgumentException ex){
            System.out.println("Error el mapa de version es nulo " + ex.getMessage());
            return 0.0;
        }
    }
}
