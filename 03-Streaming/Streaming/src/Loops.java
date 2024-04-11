import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double nota;
        double mediaEvaluacion = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Escriba la nota que le darias a la pelicula matrix");
            nota = sc.nextDouble();
            mediaEvaluacion = mediaEvaluacion + nota;
        }

        System.out.println("La media Matrix es: " + mediaEvaluacion / 3);

    }
}
