import java.util.Scanner;

public class Lectura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe nombre de tu pelicula favorita");
        String pelicula = teclado.nextLine();
        System.out.println("Escriba fecha de lanzamiento");
        int fechaLanzamiento = teclado.nextInt();
        System.out.println("Escribe una nota para la pelicula");
        double nota = teclado.nextDouble();

        System.out.println(pelicula);
        System.out.println(fechaLanzamiento);
        System.out.println(nota);
    }
}
