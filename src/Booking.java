import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    //0: Passiv, 1: Under 18, 2: Over 18, 3:Over 60
    int[] priceList = {500, 1000, 1600, 1200};

    static ArrayList<Member> members = new ArrayList<>();

    public static void createMember(Scanner scan) {

        System.out.println("Du opretter nu et nyt medlem.");
        System.out.println("Indtast navn: ");

        //Scanner input af Ledelse
        scan.nextLine();
        String name = scan.nextLine();

        System.out.println("Hvad er telefonnummeret?");
        int phoneNumber = scan.nextInt();

        System.out.println("Indtast nummer for aktiv(1) eller passiv(0): ");
        boolean active = (scan.nextInt() == 1);

        System.out.println("Indtast medlems fødselsår (I formattet xxxx): ");
        int birthYear = scan.nextInt();

        System.out.println("Indtast nummer for konkurrencesvømmer(1) eller motionist(0): ");
        boolean competitive = (scan.nextInt() == 1);


        System.out.println("Navn: " + name + "\nTelefonnummer: " + phoneNumber + "\nAktiv: " + active + "\nFødselsår: " + birthYear + "\nKonkurrencesvømmer: " + competitive);

        //Konstruer member object med scanner input
        Member newMember = new Member(name, phoneNumber, active, birthYear, competitive);
        members.add(newMember);
        UI.menu();
    }

    public static void removeMember(Scanner scan) {
        System.out.println("Du sletter nu et medlem.");
        System.out.println("Skriv telefonnummeret på det medlem du vil slette.");
        int phoneNumber = scan.nextInt();
        for (Member member : members) {
            if (member.getPhoneNumber() == phoneNumber) {
                System.out.println(member);
                System.out.println("For at bekræfte sletning tryk 1. For at annullere tryk 0.");
                int svar = scan.nextInt();
                if (svar == 1) {
                    members.remove(member);
                    System.out.println("Medlem med telefonnummer:" + phoneNumber + " er nu fjernet");
                    UI.menu();
                    break;
                } else if (svar == 0) {
                    System.out.println("Ingen bruger er slettet.");
                    UI.menu();
                } else {
                    System.out.println("Dette ser forkert ud, prøv igen.");
                    UI.menu();
                }
            }
        }
        System.out.println("Ingen bruger fundet.");
        UI.menu();
    }
}

