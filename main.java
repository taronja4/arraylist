import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        boolean continuar = true;
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        String name, numero = "";

        TelefonoMovil t = new TelefonoMovil(numero);

        while (continuar) {
            try {
                System.out.println("Elige una opcion: ");
                TelefonoMovil.imprimirMenu();
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 0:
                        System.out.println("Adiós.");
                        continuar = false;
                        break;
                    case 1:
                        System.out.println("Lista de contactos:");
                        t.printContact();
                        break;
                    case 2:
                        System.out.println("Añadir un nuevo contacto.");
                        System.out.println("Introduce el nombre del nuevo contacto");
                        name = sc.next();
                        System.out.println("Introduce el telefono del nuevo contacto");
                        numero = sc.next();
                        Contacto c = new Contacto(name, numero);
                        if (t.addNewContact(c)) {
                            System.out.println("El contacto se ha añadido.");
                        } else {
                            System.out.println("El contacto ya existe.");
                        }
                        break;
                    case 3:
                        System.out.println("Actualizar un contacto existente.");
                        System.out.println("Introduce el nombre del contacto antiguo:");
                        name = sc.next();
                        c = t.queryContact(name);
                        if (c != null) {
                            System.out.println("Intruduce el nombre del contacto actualizado:");
                            String newname = sc.next();
                            System.out.println("Intruduce el numero del contacto actualizado:");
                            String newnum = sc.next();
                            if (newnum.length() == 9) {
                                Contacto hwei = new Contacto(newname, newnum);
                                t.updateContact(c, hwei);
                            } else {
                                System.out.println("El numero de telefono no es valido.");
                            }
                        } else {
                            System.out.println("El contacto " + name + " ya existe.");
                        }
                        break;
                    case 4:
                        System.out.println("Ahora vas a eliminar un contacto.");
                        System.out.println("Intruduce el nombre del contaco que quieras eliminar: ");
                        name = sc.next();
                        c = t.queryContact(name);
                        if (c != null) {
                            t.removeContact(c);
                            System.out.println("Has eliminado el contacto.");
                        } else {
                            System.out.println("El contacto " + name + " no existe");
                        }
                        break;
                    case 5:
                        System.out.println("Ahora vas a buscar un contacto.");
                        System.out.println("Introduce el nombre del contacto:");
                        name = sc.next();
                        c = t.queryContact(name);
                        if (c != null) {
                            System.out.println("Nombre: " + c.getNombre() + " --> " + c.getNumerotel());
                        } else {
                            System.out.println("El contacto " + name + " no existe.");
                        }
                        break;
                    case 6:
                        TelefonoMovil.imprimirMenu();
                        break;
                    default:
                        System.out.println("La opcion introducida no es valida.");
                }
            } catch (InputMismatchException e){
                System.out.println("Introduzca un numero valido.");
                sc.nextLine();
            }
        }
    }
}

