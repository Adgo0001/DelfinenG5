import java.io.FileNotFoundException;

public class Handler {
    public static void main(String[] args) throws FileNotFoundException {
        FileHandler.readMembers();
        UI.menu();
    }
}