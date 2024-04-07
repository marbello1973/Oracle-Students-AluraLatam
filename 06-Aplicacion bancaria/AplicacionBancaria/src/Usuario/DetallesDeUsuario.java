package Usuario;
import java.util.*;
public class DetallesDeUsuario {
    private static UserMenu userMenu = new UserMenu();
    //private static Usuario usuario =new Usuario();

    public DetallesDeUsuario(UserMenu userMenu){
        this.userMenu = userMenu;
    }
    public DetallesDeUsuario(){}

    public void mostrarDetallesDeUsuario( Usuario usuario){

        //Ak se consultan los detalles del usuario

        System.out.println("Nombre: " + usuario.getName());
        System.out.println("Apellido: " + usuario.getLastname());
        System.out.println("Documento: " + usuario.getDocument());

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            mostrarMenu(usuario);
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
                    userMenu.mostrarMenu();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);
    }

    public void mostrarMenu(Usuario usuario){

        System.out.println(String.format("""
                ======================================
                 DETALLES CUENTA DE %s
                ======================================
                1. CONSULTAR SALDO CUENTA
                2. RETIRAR 
                3. DEPOSITAR 
                4. REGRESAR A MENU PRINCIPAL                
                ======================================
                """,usuario.name.toUpperCase()));
    }

}
