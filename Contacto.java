public class Contacto {

    private String nombre;
    private String numerotel;

    public Contacto(String nombre, String numerotel) {
        this.nombre = nombre;
        this.numerotel = numerotel;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNumerotel() {
        return numerotel;
    }
    public static Contacto createContact(String nombre,String numerotel){
        Contacto c=new Contacto(nombre,numerotel);
        return c;
    }
}