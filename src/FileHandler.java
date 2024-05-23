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

            Member curMember = null;
            for (Member member : Booking.getMembers()) {
                if (member.getPhoneNumber() == phoneNumber) {
                    curMember = member;
                }
            }

            int cnt = 8;
            while (!details[cnt].equals("endOfDiscipline")) {
                String type = details[cnt];
                float bestTime = Float.parseFloat(details[cnt+1]);
                cnt += 2;
                if(type.toLowerCase().equals("butterfly")){
                    curMember.addMemberDiscipline(1, bestTime);
                }
                if(type.toLowerCase().equals("crawl")){
                    curMember.addMemberDiscipline(2, bestTime);
                }
                if(type.toLowerCase().equals("rygcrawl")){
                    curMember.addMemberDiscipline(3, bestTime);
                }
                if(type.toLowerCase().equals("brystsvømning")){
                    curMember.addMemberDiscipline(4, bestTime);
                }
            }

            /*while (!details[cnt].equals("endOfEvents")) {
                String type = details[cnt];
                float bestTime = Float.parseFloat(details[cnt+1]);
                cnt += 2;
                if(type.toLowerCase().equals("butterfly")){
                    curMember.addMemberDiscipline(1, bestTime);
                }
                if(type.toLowerCase().equals("crawl")){
                    curMember.addMemberDiscipline(2, bestTime);
                }
                if(type.toLowerCase().equals("rygcrawl")){
                    curMember.addMemberDiscipline(3, bestTime);
                }
                if(type.toLowerCase().equals("brystsvømning")){
                    curMember.addMemberDiscipline(4, bestTime);
                }
            
            }*/
               
        }
    }
}