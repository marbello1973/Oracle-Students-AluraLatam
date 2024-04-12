package com.tarjetacredito.claseprincipal;

import com.tarjetacredito.modelos.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClasePrincipal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validador validador = new Validador();

        double nuevoCupo = 0;
        boolean entradaValida = false;

        while(!entradaValida){
            Menus.limite();
            if(sc.hasNextDouble()){
                nuevoCupo = sc.nextDouble();
                entradaValida = true;
            }else{
                System.out.println("¡Error Ingrese un valor numerico valido. ");
                sc.next();
            }
            sc.nextLine();
        }

        TarjetaCredito miTarjeta = new TarjetaCredito(nuevoCupo, 0);
        System.out.printf("Limite establecido es de -> $%.2f\n", miTarjeta.getCupoMaximo());

        List<Compras> listaComparas = new ArrayList<>();
        double totalCompra = 0;
        String continuar;
        do{
            Menus.asterisco();
            System.out.println("Ingrese el nombre del producto: ");
            String nombrePedido = sc.nextLine();

            System.out.println("Escriba el valor del producto");
            double precio = sc.nextDouble();

            if(totalCompra + precio > miTarjeta.getCupoMaximo()){
                System.out.println("¡Lo siento, has superado el límite disponible!");
                break;
            }
            sc.nextLine();

            listaComparas.add(new Compras(nombrePedido, precio));
            totalCompra += precio;
            System.out.println("Compra realizada!");
            Menus.asterisco();

            System.out.println("¿Desea agregar otra compra? (S / N)");
            continuar = sc.nextLine();

        }while(continuar.equalsIgnoreCase("s"));

        Menus.listaCompras();
        listaComparas.sort(Comparator.comparing(Producto::getValorProducto));
        for (Compras compra : listaComparas) {
            System.out.printf("Producto %s  -  Precio compra $%.2f\n", compra.getNombre(), compra.getValorProducto());
            //System.out.println("Producto: " + compra.getNombre() + "  " +"Precio compra: " + compra.getValorProducto());
        }
        System.out.printf("""
                *******************************************
                         SALDO DISPONIBLE $%.2f
                *******************************************
                """, miTarjeta.nuevoSaldo(totalCompra));
        sc.close();
    }
}







