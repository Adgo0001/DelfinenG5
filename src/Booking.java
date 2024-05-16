import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    //0: Passiv, 1: Under 18, 2: Over 18, 3:Over 60
    private static int[] priceList = {500, 1000, 1600, 1200};

    private static ArrayList<Member> members = new ArrayList<>();

    public static int[] getPriceList () {
        return priceList;
    }
    public static ArrayList<Member> getMembers() {
        return members;
    }

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

        //Konstruer member object med scanner input
        Member newMember = new Member(name, phoneNumber, active, birthYear, competitive);
        System.out.println(newMember);
        members.add(newMember);
    }

    public static void removeMember(Scanner scan) {
        System.out.println("Du sletter nu et medlem.");
        System.out.println("Skriv telefonnummeret på det medlem du vil slette.");
        int phoneNumber = scan.nextInt();
        boolean found = false;
        for (Member member : members) {
            if (member.getPhoneNumber() == phoneNumber) {
                found = true;
                System.out.println(member);
                System.out.println("For at bekræfte sletning tryk 1. For at annullere tryk 0.");
                int svar = scan.nextInt();
                if (svar == 1) {
                    members.remove(member);
                    System.out.println("Medlem med telefonnummer:" + phoneNumber + " er nu fjernet");
                    break;
                } else if (svar == 0) {
                    System.out.println("Ingen bruger er slettet.");
                } else {
                    System.out.println("Dette ser forkert ud, prøv igen.");
                }
            }
        }
        if (!found) {
            System.out.println("Ingen bruger fundet.");
        }
    }
}

