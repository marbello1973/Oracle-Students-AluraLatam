package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class EjemploStreams {

    public void muestraEjemplo(){
        List<String> name = Arrays.asList("Brenda", "Maria", "Jose", "Karen", "Luis");

        name.stream()
                .sorted()
                .forEach(System.out::println);
    }

}
