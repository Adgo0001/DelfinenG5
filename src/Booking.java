import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Booking {
    //0: Passiv, 1: Under 18, 2: Over 18, 3:Over 60
    private static int[] priceList = {500, 1000, 1600, 1200};

    public static void updatePrices(Scanner scan) {
        System.out.println("Nuværende Passiv pris: " + priceList[0] + ",-");
        System.out.println("Hvad skal den nye pris på Passiv være?");
        priceList[0] = scan.nextInt();
        System.out.println("Nuværende Junior pris: " + priceList[1] + ",-");
        System.out.println("Hvad skal den nye pris på Junior være?");
        priceList[1] = scan.nextInt();
        System.out.println("Nuværende Senior pris: " + priceList[2] + ",-");
        System.out.println("Hvad skal den nye pris på Senior være?");
        priceList[2] = scan.nextInt();
        System.out.println("Nuværende Pensionist pris: " + priceList[3] + ",-");
        System.out.println("Hvad skal den nye pris på Pensionist være?");
        priceList[3] = scan.nextInt();
    }

    private static ArrayList<Member> members = new ArrayList<>(Arrays.asList(new Member("Adrian", 12345678, true, 2020, true)));

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

    public static void editMember(Scanner scan) {
        System.out.println("Hvilket medlem kunne du tænke dig at ændre oplysninger på? (Indtast telefonnummer).");
        int phoneNumber = scan.nextInt();

        for(Member member : members){
            if (member.getPhoneNumber() == phoneNumber) {
                System.out.println("Indtast det nye navn: ");

                scan.nextLine();
                String newName = scan.nextLine();
                if (newName == "") {
                    newName = member.getName();
                }

                System.out.println("Hvad er det nye telefonnummeret?");
                int newPhoneNumber = Integer.parseInt(scan.nextLine()+"0");
                if (newPhoneNumber == 0) {
                    newPhoneNumber = member.getPhoneNumber();
                } else {
                    newPhoneNumber = newPhoneNumber / 10;
                }

                System.out.println("Indtast nummer for aktiv(1) eller passiv(0): ");
                String input = scan.nextLine()+"0";
                boolean newActive;
                System.out.println(input);
                if (input.equals("0")){
                    newActive = member.getActive();
                } else {
                    newActive = (Integer.parseInt(input) == 10);
                }
                System.out.println(newActive);

                System.out.println("Indtast medlems fødselsår (I formattet xxxx): ");
                int newBirthYear = Integer.parseInt(scan.nextLine()+"0");
                if (newBirthYear == 0) {
                    newBirthYear = member.getBirthYear();
                } else {
                    newBirthYear = newBirthYear / 10;
                }

                System.out.println("Indtast nummer for konkurrencesvømmer(1) eller motionist(0): ");
                String input2 = scan.nextLine()+"0";
                boolean newCompetitive;
                if (input2.equals("0")) {
                    newCompetitive = member.getCompetitive();
                } else {
                    newCompetitive = (Integer.parseInt(input2) == 10);
                }

                System.out.println("For at bekræfte tilføjelsen tryk 1. For at annullere tryk 0.");
                int svar = scan.nextInt();
                if (svar == 1) {
                    member.setName(newName);
                    member.setPhoneNumber(newPhoneNumber);
                    member.setActive(newActive);
                    member.setBirthYear(newBirthYear);
                    member.setCompetitive(newCompetitive);
                    System.out.println(member);
                    System.out.println("Medlemmet er nu ændret.");
                    break;
                } else if (svar == 0) {
                    System.out.println("Ingen bruger er blevet redigeret.");
                }
            }
        }
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

    public static void updateRestance(Scanner scan){
        System.out.println("Indtast telefonnummer for medlem du vil ændre restance på:");
        int phoneNumber = scan.nextInt();
        boolean found = false;
        for (Member member : members) {
            if (member.getPhoneNumber() == phoneNumber) {
                found = true;
                if (member.getRestance()) {
                    System.out.print(member.getName() + " er lige nu i restance. For at fjerne restance, tryk 1. ");
                } else {
                    System.out.print(member.getName() + " er lige nu IKKE i restance. For at sætte i restance, tryk 1. ");
                }
                System.out.println("For at annullere tryk 0.");
                int svar = scan.nextInt();
                if (svar == 1) {
                    member.changeRestance();
                    if (member.getRestance()) {
                        System.out.println(member.getName() + " er nu i restance.");
                    } else {
                        System.out.println(member.getName() + " er nu IKKE i restance.");
                    }
                    break;
                } else if (svar == 0) {
                    System.out.println("Ingen bruger er ændret.");
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

