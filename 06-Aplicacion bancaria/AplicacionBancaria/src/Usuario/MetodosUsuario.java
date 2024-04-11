package Usuario;

import DataBase.BaseDatos;
import java.util.List;
import java.util.Scanner;

public class MetodosUsuario {

    private static final BaseDatos baseDatos = new BaseDatos();
    private static DetallesDeUsuario detallesDeUsuario = new DetallesDeUsuario();

    public MetodosUsuario() {
    }

    public void consultaUsuario(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un documento: ");

        int document = sc.nextInt();

        Usuario usuario = baseDatos.obtenerUsuarioPorDocumento(document);

        try{
            if(usuario != null){
                System.out.println("Usuario encontrado: " + usuario.getDocument());
                detallesDeUsuario.mostrarDetallesDeUsuario(usuario);
            }else {
                System.out.println("Documento no existe en base de datos: ");
            }
        }catch(Exception ex){
           ex.printStackTrace();
        }


    }

    public void IngresarNuevoUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese documento: ");
        int document = sc.nextInt();

        Usuario nuevoUsuario = new Usuario(nombre, apellido, document);
        baseDatos.addUser(nuevoUsuario);
        System.out.println("Usuario creado");

    }

    public void obtenerTodosLosUsuarios(){
        List<Usuario> usuarios = baseDatos.obtenerTodosLosUsuarios();
        if(usuarios != null && !usuarios.isEmpty()){
            System.out.println("Lista de usuarios");
            for(Usuario usuario : usuarios){
                System.out.println(usuario.getName() + " " + usuario.getLastname() + " " + usuario.getDocument());
            }
        }else {
            System.out.println("No existen usuarios");

        }
    }
}

