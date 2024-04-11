package Usuario;

import Menus.MenuPrincipal;
import java.util.Scanner;
public class UserMenu {
    MetodosUsuario metodosUsuario = new MetodosUsuario();
    public void UserMenu(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            MenuPrincipal.mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    metodosUsuario.consultaUsuario();
                    break;
                case 2:
                    metodosUsuario.IngresarNuevoUsuario();
                    break;
                case 3:
                    metodosUsuario.obtenerTodosLosUsuarios();
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while (opcion != 4);
        sc.close();
    }

}
