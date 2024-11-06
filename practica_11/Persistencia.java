import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persistencia implements Serializable {

    private static final long serialVersionUID = 1;
    private static final String FINAL_NAME = "persistent.bin";
    private int a;
    private int b;

    public void set(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String Get_toString() {
        return "(" + a + ", " + b + ")";
    }

    public void Persistencia() {
        try (FileOutputStream fos = new FileOutputStream(FINAL_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
