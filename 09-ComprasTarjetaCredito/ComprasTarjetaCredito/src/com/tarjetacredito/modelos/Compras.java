package com.tarjetacredito.modelos;

public class Compras extends Producto {
    private String nombre;

    public Compras(String nombre, double valorProducto) {
        this.nombre = nombre;
        this.setValorProducto(valorProducto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

       @Override
    public String toString() {
        return "Compras: " + getNombre() + "(" + getValorProducto() +")";
    }



}
