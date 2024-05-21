import java.io.FileNotFoundException;
import java.util.Scanner;

public class Handler {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        FileHandler.readMembers();
        UI.menu();

    }


    public static void handleInput() {
    }
}