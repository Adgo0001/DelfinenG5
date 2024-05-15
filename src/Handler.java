import java.util.Scanner;

public class Handler {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Booking booking = new Booking();
        booking.deleteUser(scan);
        UI.menu();

    }


    public static void handleInput() {
    }
}