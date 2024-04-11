public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido(a) a Screen Match");
        System.out.println("Pelicula: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluyeEnPlan = true;
        double notaDeLaPelicula = 8.2;
        double media = (8.2 + 6.0 + 9.0) / 3;
        System.out.println(media);

        String sinopsis = """
                Matrix es una paradoja
                La mejor pelicula del fin del milenio
                Fue lanzada en:
                """ + fechaDeLanzamiento;
        System.out.println(sinopsis);

        int clasificacion = (int) (media / 2);
        System.out.println(clasificacion);




    }
}



//System.out.println(String.format("Fecha de lanzamiento es: %d, Incluye plan: %b, Nota %.2f, media %.2f", fechaDeLanzamiento, incluyeEnPlan, notaDeLaPelicula, media));
/*
* float floatconverter = (float) (media / 2);
        String cadena = String.valueOf(media / 2);


        System.out.println("int: " + clasificacion);
        System.out.println("Float: " + floatconverter);
        System.out.println("Cadena: " + cadena);


        //alicia

        String saludo = "Hola, mi nombre es ";
        String nombre= "Alicia ";
        String continuacion = "y mi edad es ";
        int edad = 17;
        System.out.println(saludo + nombre + continuacion + edad);
*
*
* */