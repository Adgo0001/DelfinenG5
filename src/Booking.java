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

    private static ArrayList<Member> members = new ArrayList<> ();

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

        //Konstruer member object med scanner input
        Member newMember = new Member(name, phoneNumber, active, birthYear);
        System.out.println(newMember);
        members.add(newMember);
    }

    public static void recreateMember(String name, int phoneNumber, boolean active, int birthYear, boolean competitive, boolean restance, String trainer) {
        Member newMember = new Member(name, phoneNumber, active, birthYear, competitive, restance, trainer);
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

                System.out.println("For at bekræfte tilføjelsen tryk 1. For at annullere tryk 0.");
                int svar = scan.nextInt();
                if (svar == 1) {
                    member.setName(newName);
                    member.setPhoneNumber(newPhoneNumber);
                    member.setActive(newActive);
                    member.setBirthYear(newBirthYear);
                    System.out.println(member);
                    System.out.println("Medlemmet er nu ændret.");
                    break;
                } else if (svar == 0) {
                    System.out.println("Ingen bruger er blevet redigeret.");
                }
            }
        }
    }

    public static void editCompetitive(Scanner scan){
        System.out.println("Hvilket medlem kunne du tænke dig ændre konkurrencestatus på? (Indtast telefonnummer):");
        int phoneNumber = scan.nextInt();

        for(Member member : members) {
            if (member.getPhoneNumber() == phoneNumber) {
                if (member.getCompetitive()) {
                    System.out.println(member.getName() + " er lige nu en konkurrencesvømmer.");
                } else {
                    System.out.println(member.getName() + " er lige nu IKKE en konkurrencesvømmer.");
                }
                System.out.println("Vil du ændre medlemmets konkurrencestatus? (j/n): ");
                char svar = scan.next().charAt(0);
                if (svar == 'j') {
                    member.setCompetitive(!member.getCompetitive());
                    System.out.println("Konkurrencestatus for " + member.getName() + " er nu ændret.");
                } else {
                    System.out.println("Ingen ændringer foretaget.");
                }
            }
        }
    }

    public static void editTrainer(Scanner scan){
        System.out.println("Hvilket medlem kunne du tænke dig tilføje/ændre træner på? (Indtast telefonnummer):");
        int phoneNumber = scan.nextInt();

        for(Member member : members) {
            if (member.getPhoneNumber() == phoneNumber) {
                System.out.println(member.getName() + " har lige nu træner: " + member.getTrainer() + ".");
                System.out.println("Vil du ændre medlemmets træner? (j/n): ");
                char svar = scan.next().charAt(0);
                String newTrainer;
                if (svar == 'j') {
                    System.out.println("Indtast trænerens navn: ");
                    scan.nextLine();
                    newTrainer = scan.nextLine();
                    member.setTrainer(newTrainer);
                    System.out.println("Medlemmet har nu fået ny træner.");
                } else {
                    System.out.println("Ingen ændringer foretaget.");
                }
            }
        }
    }

    public static void addDiscipline(Scanner scan) {
        System.out.println("Hvilket medlem kunne du tænke dig at tilføje disciplin til? (Indtast telefonnummer).");
        int phoneNumber = scan.nextInt();

        for(Member member : members){
            if (member.getPhoneNumber() == phoneNumber) {
                System.out.print(member.getName() + " har lige nu disciplinerne: ");
                if (member.getDisciplines().isEmpty()) {
                    System.out.println("Ingen discipliner");
                }
                for (Discipline discipline: member.getDisciplines()) {
                    System.out.print(discipline + ", ");
                }
                System.out.println();
                System.out.println("Vælg ny disciplin (1: butterfly, 2: crawl, 3: rygcrawl, 4: brystsvømning): ");
                int valg = scan.nextInt();
                // TODO: indsæt fejlbehandling hvis man taster andet end 1-4
                System.out.println("Vil du tilføje en PR til denne disciplin? (j/n): ");
                char addPR = scan.next().charAt(0);
                if (addPR == 'j'){
                    System.out.println("Indtast PR (minutter.sekunder fx 7,58): ");
                    float pr = scan.nextFloat();
                    member.addMemberDiscipline(valg, pr);
                    System.out.println("Ny disciplin med PR tilføjet.");
                } else {
                    member.addMemberDiscipline(valg, 0.0f);
                    System.out.println("Ny disciplin uden PR tilføjet.");
                }
            }


        }
    }

    public static void addEvent(Scanner scan){
        System.out.println("Hvilket medlem kunne du tænke dig at tilføje et event til? (Indtast telefonnummer).");
        int phoneNumber = scan.nextInt();

        for(Member member : members){
            if (member.getPhoneNumber() == phoneNumber) {
                System.out.print(member.getName() + " har lige nu disciplinerne: ");
                if (member.getDisciplines().isEmpty()) {
                    System.out.println("Medlemmet har ingen discipliner, og der kan derfor ikke tilføjes nogle events");
                    break;
                }
                //TODO: Vis også events for medlemmet
                for (Discipline discipline: member.getDisciplines()) {
                    System.out.print(discipline + ", ");
                }
                System.out.println();
                //TODO: indsæt fejlbehandling hvis man taster andet end 1-4
                System.out.println("Vælg en disciplin, som der skal tilføjes event til (1: butterfly, 2: crawl, 3: rygcrawl, 4: brystsvømning): ");
                String[] disciplineNames = {"butterfly", "crawl", "rygcrawl", "brystsvømning"};
                int valg = scan.nextInt();

                boolean found = false;
                for (Discipline discipline : member.getDisciplines()) {
                    if (discipline.getType().toLowerCase().equals(disciplineNames[valg-1].toLowerCase())) {
                        System.out.println("Navn på eventet?");
                        scan.nextLine();
                        String eventName = scan.nextLine();
        
                        System.out.println("Hvilken plads kom medlemmet på?");
                        int eventPlacement = scan.nextInt();
        
                        System.out.println("Hvad tid fik medlemmet? (min,sek)");
                        float eventTime = scan.nextFloat();

                        discipline.createEvent(eventName, eventTime, eventPlacement, discipline.getType().toLowerCase());
                        found = true;
                    }   
                }
                
                if(!found){
                    System.out.println("Medlemmet har ikke denne disciplin. Du vil blive sendt tilbage til hovedmenuen.");
                    break;
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
    public static void saveMembers(){
        StringBuilder sb = new StringBuilder();
        int a = 0;
        for(Member member: members){
            sb.append(member.getName()).append(",");
            sb.append(member.getPhoneNumber()).append(",");
            sb.append(member.getActive()).append(",");
            sb.append(member.getBirthYear()).append(",");
            sb.append(member.getCompetitive()).append(",");
            sb.append(member.getRestance()).append(",");
            sb.append(member.getTrainer()).append(",");
            sb.append("endOfMember").append(",");
            for (Discipline discipline : member.getDisciplines()) {
                sb.append(discipline.getType()).append(",");
                sb.append(discipline.getBestTime()).append(",");
            }
            sb.append("endOfDisciplines").append(",");
            for (Discipline discipline : member.getDisciplines()) {
                for (Event event : discipline.getEvents()) {
                    sb.append(event.getName()).append(",");
                    sb.append(event.getPlacement()).append(",");
                    sb.append(event.getTime()).append(",");
                    sb.append(event.getType());
                }
            }
            sb.append("endOfEvents");
            a++;
            if (a < members.size()) {
                sb.append("\n");
            }
        }
        FileHandler.writeMember(sb.toString());

    } //TODO ændre saveUsers til saveMembers i klassediagrammet
}

