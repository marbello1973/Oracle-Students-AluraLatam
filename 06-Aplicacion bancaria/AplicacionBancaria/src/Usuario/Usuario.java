package Usuario;

public class Usuario {
    private String name;
    private String lastname;
    private Integer document;

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

    public String setName(String name) {
        return this.name = name;
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
