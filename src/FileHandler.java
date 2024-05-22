import java.io.*;
import java.util.*;

public class FileHandler {
    public static void writeMember(String content){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src\\members.txt", false))){
            writer.append(content);
        }catch (IOException e){
            System.out.println("Error found" + e.getMessage());
        }
    }

    public static void readMembers() throws FileNotFoundException {
        Scanner input = new Scanner(new File("src\\members.txt"));
        while (input.hasNextLine()) {
            String[] details = input.nextLine().split(",");

            String name = details[0];
            int phoneNumber = Integer.parseInt(details[1]);
            boolean active = Boolean.parseBoolean(details[2]);
            int birthYear = Integer.parseInt(details[3]);
            boolean competitive = Boolean.parseBoolean(details[4]);
            boolean restance = Boolean.parseBoolean(details[5]);
            String trainer = details[6];

            Booking.recreateMember(name, phoneNumber, active, birthYear, competitive, restance, trainer);
        }
    }
}