package com.ebook.principal;

public class Principal {
    public void datosDeConsulta(){

        BusquedaTituloAuthor busquedaTituloAuthor = new BusquedaTituloAuthor();
        busquedaTituloAuthor.busquedaTituloAuthor();

        BusquedaPorID busquedaPorID = new BusquedaPorID();
        busquedaPorID.busquedaID();

        BusquedaPorDescargas busquedaPorDescargas = new BusquedaPorDescargas();
        busquedaPorDescargas.busquedaDescargas();

        BusquedaPorTemas busquedaPorTemas = new BusquedaPorTemas();
        busquedaPorTemas.busquedaLibrosPorTemas();

        BusquedaAutoresEndStart busquedaAutoresEndStart = new BusquedaAutoresEndStart();
        busquedaAutoresEndStart.busquedaRangoAutores();

    }
}
