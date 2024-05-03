package com.ebook.principal;

import com.ebook.modelo.DatosLibros;
import com.ebook.modelo.LibroResults;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class BusquedaPorDescargas implements IPrincipal{
    public void busquedaDescargas(){
        //obtener los libros con mayor descarga
        List<DatosLibros> datosLibros = new ArrayList<>();
        var json = consultaApi.obtenerDatosDeLaApi(url);
        var datos = conversor.obtenerDatos(json, DatosLibros.class);
        datosLibros.add(datos);

        for(DatosLibros result : datosLibros){
            //System.out.println("Result for: " + result.results());
            DoubleSummaryStatistics estadisticasDescargas = result.results().stream()
                    .filter(d -> d.download_count() >= 0 || d.download_count() <= 1129739)
                    .collect(Collectors.summarizingDouble(LibroResults::download_count));
            System.out.println("Descargas totales: " + estadisticasDescargas.getSum());
            System.out.println("Descargas min: " + estadisticasDescargas.getMin());
            System.out.println("Descargas max: " + estadisticasDescargas.getMax());
            System.out.println("Descargas average: " + estadisticasDescargas.getAverage());

            if(estadisticasDescargas.getMin() >= 0 || estadisticasDescargas.getMin() <= 500 ) {
                result.results().forEach(n -> System.out.println("Titulo min: " + n.titulo()));
            }
        }

        System.out.println("Top 10 libros mas descargados");
        datos.results().stream()
                .sorted(Comparator.comparing(LibroResults::download_count).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);
    }
}
