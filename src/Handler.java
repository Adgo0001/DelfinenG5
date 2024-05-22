import java.io.FileNotFoundException;
import java.util.Scanner;

public class Handler {
    public static void main(String[] args) throws FileNotFoundException {
        FileHandler.readMembers();
        UI.menu();
    }
    public static void handleInput() {
    }
}