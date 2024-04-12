package com.tarjetacredito.modelos;

public abstract class Producto {
   private double valorProducto;

    public Producto(double valorProducto) {
        this.valorProducto = valorProducto;
    }

    public Producto() {
    }

    public double getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(double valorProducto) {
        this.valorProducto = valorProducto;
    }


}
