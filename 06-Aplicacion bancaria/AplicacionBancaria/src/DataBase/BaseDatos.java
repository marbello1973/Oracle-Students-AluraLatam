package DataBase;

import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    private List<Usuario> usuarios;

    public BaseDatos(){
        usuarios = new ArrayList<>();
    }

    public void addUser(Usuario usuario){
        usuarios.add(usuario);
    }

    public Usuario obtenerUsuarioPorDocumento(int document){
        for(Usuario usario : usuarios){
            if(usario.getDocument() == document){
                return usario;
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarios;
    }


}
