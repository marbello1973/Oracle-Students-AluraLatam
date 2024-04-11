import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Conversor de temperatura");

        String input = sc.nextLine();
        input = input.replace(',','.');

        double celsius;
        //double num = Double.parseDouble(String.valueOf(celsius).replace('.', ','));

        try {
            celsius = Double.parseDouble(input);
        }catch(NumberFormatException ex){
            System.out.println("Ingrese valor numerico");
            sc.close();
            return;
        }

        double fahrenheit = convertirCelsiusFahrenheit(celsius);
        System.out.println(String.format("%.2f grado(s) Celsius es equivalentes a %.2f grados fahrenheit", celsius, fahrenheit));
        int fahrenheitSinDecimales = (int) fahrenheit;
        System.out.println(String.format("%d Grados Fahrenheits sin decimales: ", fahrenheitSinDecimales));

        sc.close();
    }

    public static double convertirCelsiusFahrenheit(double celsius){
        return (celsius * 1.8) + 32;
    }
}