import java.io.*;
import java.util.Scanner;

public class Practica_11 {

    private static final String FINAL_NAME = null;

    public static Persistencia recuperar() {
        try (FileInputStream fis = new FileInputStream(FINAL_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Persistencia) ois.readObject();
        } catch (FileNotFoundException e) {
            return null; // regresa el null
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Intentando recuperar objeto persistente");

            Persistencia pObj = Persistencia.recuperar();

            // crea si no hay nada
            if (pObj == null) {
                System.out.println("El objeto persistente será creado por primera vez");
                pObj = new Persistencia();
            } else {
                // modifica
                System.out.println("Objeto recuperado: " + pObj);
                System.out.print("Deseas modificarlo? (S/N): ");
                String option = in.next();
                if (Character.toUpperCase(option.charAt(0)) != 'S') {
                    return;
                }
            }

            // agarra valores
            System.out.print("Introduce valor a: ");
            int a = in.nextInt();
            System.out.print("Introduce valor b: ");
            int b = in.nextInt();

            // Set
            pObj.set(a, b);

            // Persist
            pObj.persistir();
            System.out.println("Objeto actualizado y persistido.");
        }
    }

}
