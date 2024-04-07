package Usuario;

public class Usuario {
    public String name;
    public String lastname;
    public Integer document;

    public Usuario(String name, String lastname, Integer document) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
    }

    public Usuario() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Usuario.Usuario{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", document=" + document +
                '}';
    }

}
