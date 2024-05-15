import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    //0: Passiv, 1: Under 18, 2: Over 18, 3:Over 60
    int[] priceList = {500, 1000, 1600, 1200};

    ArrayList<Member> members = new ArrayList<Member>();

    public void createUser(Scanner scan){
        
        System.out.println("Du opretter nu et nyt medlem.");
        System.out.println("Indtast navn: ");

        //Scanner input af Ledelse
        String name = scan.nextLine();

        System.out.println("Indtast nummer for aktiv(1) eller passiv(0): ");
        boolean active = (scan.nextInt() == 1);

        System.out.println("Indtast medlems fødselsdato (I formattet xx/xx-xxxx): ");
        String dateOfBirth = scan.next();

        System.out.println("Indtast nummer for konkurrencesvømmer(1) eller motionist(0): ");
        boolean competitive = (scan.nextInt() == 1);

        System.out.println("Navn: " + name + "\nactive: " + active + "\ndateOfBirth: " + dateOfBirth +"\ncompetitive: "+ competitive);

        //Konstruer member object med scanner input
        //Member newMember = new Member(name, active, dateOfBirth, competitive);
        //members.add(newMember);

    }
    public void deleteUser(Scanner scan){
        System.out.println("Du sletter nu et medlem.");
        for(Member member: members){
            System.out.println(member.toString());
        }
        System.out.println("Skriv ID'et på det medlem du vil slette.");
        int idToRemove = scan.nextInt();
        /*for(int i = 0; i < members.size(); i++){
            if(member.getID == idToRemove){
                members.remove(i);
                System.out.println("Medlem med id:" + idToRemove + "er nu fjernet");
            }
        }*/
    }
}
