package com.literalura.menusyopciones;

public class MostrarMenu {
    public void mostrarMenuOpciones(){
        opcionDobleLinea();
        System.out.println("""
                          
               1 - Registrar libro en base de datos
               2 - Mostrar libros registrados
               3 - Mostrar lista de autores registrados
               4 - Mostrar autores vivos en determinado año
               5 - Buscar libro por idioma
           
               0 - Salir                               
                """);
        opcionDobleLinea();
    }

    public void opcionUnaLinea(){
        System.out.println("-------------------------------------------------");
    }

    public void opcionDobleLinea(){
        System.out.println("============================================================================================");
    }

}
