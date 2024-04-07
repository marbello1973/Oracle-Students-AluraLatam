import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int contador = 5;
        int numeroAleatorio = new Random().nextInt(100);
        int numeroUsuario;
        System.out.println("""
                ==============================================================================        
                                          JUGEMOS ADIVINA EL NUMERO
                       INGRESA UN NUMERO MAYOR O IGULA A CERO 0, Y MENOR IGUAL A CIEN 100
                ==============================================================================                     
                """);

        for (int i = 1; i <= 5; i++) {
            contador--;
            if(sc.hasNextInt()){
                numeroUsuario = sc.nextInt();
                System.out.println("==============================================================================");
                if(numeroUsuario > 100 || numeroUsuario < 0){
                    System.out.println(String.format("Numero %d fuera de rango, %d intentos disponibles ", numeroUsuario, contador));
                }else{
                    if(numeroUsuario != numeroAleatorio){
                        System.out.println(String.format("Te quedan %d intentos", contador));
                        if(numeroUsuario < numeroAleatorio){
                            System.out.println("Pista..! estas cerca -- MAYOR --");
                        }else{
                            System.out.println("Pista..! ya casi -- MENOR --");
                        }
                    }else{
                        System.out.println(String.format("Felicidades, ganastes %d ==> corresponde al numero aleatorio", numeroUsuario));
                        break;
                    }
                }
            }else{
                System.out.println(String.format("Se esperaba un numero, te quedan %d ", contador));
                sc.next();
            }
            System.out.println("==============================================================================");
        }
        System.out.println(String.format("Numero es %d ", numeroAleatorio));
        System.out.println("============================================================================== ");
        sc.close();
    }
}

/*
for (int i = 0; i <= 4; i++) {
            if(sc.hasNextInt()){
                numeroUsuario = sc.nextInt();
                if(numeroUsuario != numeroAleatorio){
                    contador--;
                    System.out.println(String.format("Te quedan %d intentos", contador));
                }else{
                    System.out.println(String.format("Felicidades, ganastes %d ==> corresponde al numero aleatorio", numeroUsuario));
                    break;
                }
            }else{
                System.out.println("Se esperaba un numero ");
                sc.next();
            }
        }
*/


/*

 for (int i = 0; i <= 4 ; i++) {
        if(!sc.hasNextInt()) System.out.println(String.format("Se esperaba un numero %d ", numeroUsuario));
numeroUsuario = sc.nextInt();
            if(numeroUsuario != numeroAleatorio) System.out.println(String.format("Te quedan %d intentos", contador--));
        if (numeroUsuario == numeroAleatorio) System.out.println(String.format("Ganaste %d ", numeroAleatorio));
        }
*/
