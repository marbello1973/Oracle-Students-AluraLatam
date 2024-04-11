package Menus;
import Usuario.Usuario;

public class MenuDetalleCuenta {
    public static void mostrarMenu(Usuario usuario){
        System.out.println(String.format("""
                ======================================
                 DETALLES CUENTA DE %s
                ======================================
                1. CONSULTAR SALDO CUENTA
                2. RETIRAR 
                3. DEPOSITAR 
                4. REGRESAR A MENU PRINCIPAL                
                ======================================
                """,usuario.setName(usuario.getName().toUpperCase())));
    }
}
