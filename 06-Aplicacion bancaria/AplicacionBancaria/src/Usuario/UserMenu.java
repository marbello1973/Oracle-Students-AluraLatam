package Usuario;

import java.util.Scanner;
public class UserMenu {
    MetodosUsuario metodosUsuario = new MetodosUsuario();
    public void UserMenu(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            mostrarMenu();
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
    public void mostrarMenu(){
        System.out.println("""
                ======================================
                           MENU DE PRINCIPAL
                ======================================
                1. CONSULTAR USUARIO
                2. REGISTRAR USUARIO
                3. OBTENER LISTA USUARIOS
                4. SALIR
                5. INGRESE UNA OPCION 
                """);
    }
}
