package com.tarjetacredito.modelos;

public class TarjetaCredito extends Producto {
    private double cupoMaximo;
    private double saldo;

    Validador validador = new Validador();

    public TarjetaCredito(double cupoMaximo, double saldo) {
        this.cupoMaximo = cupoMaximo;
        //validador.validarEntradaNumerica(cupoMaximo);
        this.saldo = saldo;
    }

    public double nuevoSaldo(double valorProducto){
        saldo = cupoMaximo - valorProducto;
        return saldo;
    }

    public double getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(double cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public double getSaldo() {
        return saldo = getCupoMaximo() - getValorProducto();

    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
