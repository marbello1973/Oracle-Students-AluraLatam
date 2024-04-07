package Usuario;
import java.util.Scanner;

public class TransaccionesDeUsuario {
    private static double saldo = 0;

    public static void consultarSaldo(){
        System.out.println("Consultar saldo: " + saldo);
    }

    public static void depositarDinero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a depositar: ");
        double deposito = sc.nextDouble();
        saldo += deposito;
        System.out.println("Depositar dinero: " + deposito);
        System.out.println("Saldo actula: " + saldo);

    }

    public static void retirarDinero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a retirar: ");
        double retirar = sc.nextDouble();
        if(retirar < saldo){
            saldo -= retirar;
            System.out.println("Retiro la cantidad de: " + retirar);
            System.out.println("Saldo actual: " + saldo);
        }else{
            System.out.println("Saldo insuficiente");
        }

    }

}
