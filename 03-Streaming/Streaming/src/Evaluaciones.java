import java.util.Scanner;

public class Evaluaciones {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota = 0;
        double mediaEvaluacion = 0;
        double totalEvaluaciones = 0;

        while (nota != -1){
            System.out.println("Escriba la nota que le darias a la pelicula matrix");
            nota = sc.nextDouble();
            if(nota != -1){
                mediaEvaluacion += nota;
                totalEvaluaciones++;
            }
        }
        System.out.println("La media Matrix es: " + mediaEvaluacion / totalEvaluaciones);
    }
}
