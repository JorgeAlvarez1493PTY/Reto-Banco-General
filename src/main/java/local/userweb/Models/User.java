package local.userweb.Models;

public class User {
    private int id;
    private String nombre;
    private String apellido;

    public User() {  }

    public User(int id, String nombre, String apellido) {
        this.setId(id);
        this.setnombre(nombre);
        this.setapellido(apellido);
    }

    public User(String nombre, String apellido) {
        this.setnombre(nombre);
        this.setapellido(apellido);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
