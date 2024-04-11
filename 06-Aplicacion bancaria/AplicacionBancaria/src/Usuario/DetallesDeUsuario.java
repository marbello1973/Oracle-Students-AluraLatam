package Usuario;
import Menus.MenuDetalleCuenta;
import Menus.MenuPrincipal;

import java.util.*;
public class DetallesDeUsuario {
    public DetallesDeUsuario(){}
    public void mostrarDetallesDeUsuario( Usuario usuario){

        //Ak se consultan los detalles del usuario

        System.out.println("Nombre: " + usuario.getName());
        System.out.println("Apellido: " + usuario.getLastname());
        System.out.println("Documento: " + usuario.getDocument());

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            MenuDetalleCuenta.mostrarMenu(usuario);
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    TransaccionesDeUsuario.consultarSaldo();
                    break;
                case 2:
                    TransaccionesDeUsuario.retirarDinero();
                    break;
                case 3:
                    TransaccionesDeUsuario.depositarDinero();
                    break;
                case 4:
                    MenuPrincipal.mostrarMenu();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
    }
}
