import java.sql.SQLOutput;
import java.util.*;

public class UI {
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int menuChoice = 0;
        while(menuChoice != -1){
            System.out.println("\nHvad kunne du tænkte dig at gøre?");
            System.out.println("1. Medlemshåndtering.");
            System.out.println("2. Økonomi.");
            System.out.println("3. Se svømmeresultater.");
            System.out.println("9. Afslut program");
            menuChoice = scan.nextInt();

            switch (menuChoice) {
                case 1:
                    case1SwitchMenu(scan);
                    break;
                case 2:
                    case2SwitchMenu(scan);
                    break;
                case 3:
                    case3SwitchMenu(scan);
                    break;
                case 4:
                    Booking.saveMembers();
                    break;
                case 9:
                    menuChoice = -1;
                    break;
                default:
                    System.out.println("Ikke muligt, prøv igen!");
                    break;
            }
        }
    }

    public static void case1SwitchMenu(Scanner scan) {
            System.out.println("\nHvad vil du kunne med dit medlem?");
            System.out.println("1. Opret medlem.");
            System.out.println("2. Rediger medlem.");
            System.out.println("3. Slet medlem.");
            System.out.println("9. Gå til hovedmenu.");
            int case1SwitchChoice = scan.nextInt();

            switch (case1SwitchChoice) {
                case 1:
                    Booking.createMember(scan);
                    break;
                case 2:
                    System.out.println("rediger medlem");
                    Booking.editMember(scan);
                    break;
                case 3:
                    Booking.removeMember(scan);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Ikke muligt, prøv igen!");
                    case1SwitchMenu(scan);
                    break;
            }
        }

    public static void case2SwitchMenu(Scanner scan) {
            System.out.println("\nHvad kunne du tænkte dig at gøre med økonomien?");
            System.out.println("1. Se omsætning.");
            System.out.println("2. Se restancer.");
            System.out.println("3. Ændre kontingent priser.");
            System.out.println("4. Sæt/fjern medlem i restance");
            System.out.println("9. Gå til hovedmenu.");
            int case2SwitchChoice = scan.nextInt();

            switch (case2SwitchChoice) {
                case 1:
                    Finance.checkRevenue();
                    break;
                case 2:
                    //printMembersRestance();
                    break;
                case 3:
                    Booking.updatePrices(scan);
                    break;
                case 4:
                    Booking.updateRestance(scan);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Ikke muligt, prøv igen!");
                    case2SwitchMenu(scan);
                    break;
            }
        }
        public static void case3SwitchMenu(Scanner scan) {
            System.out.println("\nHvad kunne du tænkte dig at gøre med svømmeresultater?");
            System.out.println("1. Se...");
            System.out.println("2. Se...");
            System.out.println("3. ");
            System.out.println("9. Gå til hovedmenu.");
            int case2SwitchChoice = scan.nextInt();

            switch (case2SwitchChoice) {
                case 1:
                    Finance.checkRevenue();
                    break;
                case 2:
                    //();
                    break;
                case 3:
                    //();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Ikke muligt, prøv igen!");
                    case3SwitchMenu(scan);
                    break;
            }
        }
    }