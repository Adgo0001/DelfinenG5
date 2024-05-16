import java.util.*;

public class UI {
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        while(){
            System.out.println("Hvad kunne du tænkte dig at gøre?");
            System.out.println("1. Medlemshåndtering");
            System.out.println("2. Økonomi");
            System.out.println("3. ");
            int menuChoice = scan.nextInt();

            switch (menuChoice) {
                case 1:
                    System.out.println("1. Medlemshåndtering.");
                    case1SwitchMenu(scan);
                    break;
                case 2:
                    System.out.println("2. Økonomi");
                    case2SwitchMenu(scan);
                    break;
                case 3:
                    System.out.println("3. Svømme");
                    //();
                default:
                    System.out.println("Ikke muligt, prøv igen");
                    menu();
                    break;
            }
        }
    }

    public static void case1SwitchMenu(Scanner scan){
        System.out.println("Hvad vil du kunne med dit medlem?");
        System.out.println("1. opret medlem");
        System.out.println("2. rediger medlem");
        System.out.println("3. slet medlem");
        int case1SwitchChoice = scan.nextInt();

        switch (case1SwitchChoice) {
            case 1:
                System.out.println("opret medlem");
                Booking.createMember(scan);
                break;
            case 2:
                System.out.println("rediger medlem");
                //editMember();
                break;
            case 3:
                System.out.println("slet medlem");
                Booking.removeMember(scan);
                break;
            default:
                System.out.println("ikke muligt, prøv igen.");
                case1SwitchMenu(scan);
                break;
        }
    }

    public static void case2SwitchMenu(Scanner scan){
        System.out.println("Hvad kunne du tænkte dig at gøre med økonomien?");
        System.out.println("1. Se omsætning.");
        System.out.println("2. Se restancer.");
        System.out.println("3. ");
        int case2SwitchChoice = scan.nextInt();

        switch(case2SwitchChoice) {
            case 1:
                System.out.println("OMSÆTNING");
                //checkRevenue();
                break;
            case 2:
                System.out.println("RESTANCER");
                //printMembersRestance();
                break;
            case 3:
                System.out.println("");
                //();
                break;
            default:
                System.out.println("Ikke muligt, prøv igen!");
                case2SwitchMenu(scan);
                break;
        }
    }
}