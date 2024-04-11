import Usuario.UserMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //ingresar al menus de usuario con contraseña

        Scanner sc = new Scanner(System.in);
        int password = 1234;
        System.out.println(String.format("""
                ======================================
                    DIGITE CLAVE PARA INGRESAR %d     \s
                ======================================
                """, password));
        int passw = sc.nextInt();
        if(password != passw){
            System.out.println(String.format("%d CLAVE INVALIDA", passw));
        }else{
            UserMenu userMenu = new UserMenu();
            userMenu.UserMenu();
        }
        sc.close();

    }
}