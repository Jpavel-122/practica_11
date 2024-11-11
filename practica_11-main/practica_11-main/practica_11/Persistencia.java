import java.io.*;

public class Persistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String FINAL_NAME = "persistent.bin"; // Filename for the persistent object
    private int a;
    private int b;

    // Constructor
    public Persistencia() {
        this.a = 0;
        this.b = 0;
    }

    // Set
    public void set(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    // Metodo persistir
    public void persistir() {
        try (FileOutputStream fos = new FileOutputStream(FINAL_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Metodo recuperar
    public static Persistencia recuperar() {
        try (FileInputStream fis = new FileInputStream(FINAL_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Persistencia) ois.readObject(); // Deserialize the object
        } catch (FileNotFoundException e) {
            //
            return null;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
