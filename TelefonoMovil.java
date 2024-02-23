import java.util.ArrayList;
import java.util.List;

public class TelefonoMovil {

    private String miNumero;
    private List<Contacto> Miscontacto;

    public TelefonoMovil(String miNumero) {
        this.miNumero = miNumero;
        Miscontacto = new ArrayList<Contacto>();
    }

    private int findContact(Contacto c){
        return Miscontacto.indexOf(c);
    }

    public boolean addNewContact(Contacto nuevoContacto) {
        if (findContact(nuevoContacto.getNombre()) == null) {
            Miscontacto.add(nuevoContacto);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contacto contactoEliminar) {
        return Miscontacto.remove(contactoEliminar);
    }

    public boolean updateContact(Contacto contactoAntiguo, Contacto nuevoContacto) {
        int indice = findContact(contactoAntiguo);
        if (indice != -1 && findContact(nuevoContacto.getNombre()) == null) {
            Miscontacto.set(indice, nuevoContacto);
            return true;
        } else {
            return false;
        }
    }

    public Contacto queryContact(String nombre) {
        return findContact(nombre);
    }

    private Contacto findContact(String nombre) {
        for (Contacto contacto : Miscontacto) {
            if (contacto.getNombre().equals(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void printContact() {
        System.out.println("Lista de contactos:");
        int index = 1;
        for (Contacto contacto : Miscontacto) {
            System.out.println(index + ". " + contacto.getNombre() + " -> " + contacto.getNumerotel());
            index++;
        }
    }
    public static void imprimirMenu(){
        System.out.println("0. Salir.");
        System.out.println("1. Imprimir contactos.");
        System.out.println("2. Agregar contactos.");
        System.out.println("3. Actualizar contactos.");
        System.out.println("4. Eliminar contactos.");
        System.out.println("5. Buscar contactos.");
        System.out.println("6. Volver a mostrar el menu");
    }
}