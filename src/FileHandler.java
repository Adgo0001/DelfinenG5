import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static void writeMember(String content){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src\\members.txt", true))){
            writer.append(content);
            writer.newLine();
        }catch (IOException e){
            System.out.println("Error found" + e.getMessage());
        }
    }

    public static void readMember(){}
}
//    public static void saveToFile(String fileName, String content){
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
//            writer.append(content);
//            writer.newLine();
//        } catch (IOException e){
//            System.err.println("Error writing to file: " + e.getMessage());
//        }
//    }
//    public static String readFromFile(String fileName)throws IOException{
//        StringBuilder content = new StringBuilder();
//        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                content.append(line).append("\n");
//            }
//        }
//        return content.toString();
//    }
//    private static String constructCarString(Car car){
//        StringBuilder sb = new StringBuilder();
//        sb.append(car.getBrandType()).append(",");
//        sb.append(car.getModelType()).append(",");
//        sb.append(car.getFuelType()).append(",");
//        sb.append(car.getRegistrationNumber()).append(",");
//        sb.append(car.getFirstRegistration()).append(","); //TODO: RENAME
//        sb.append(car.getKmDriven()).append(",");
//        sb.append(car.getCcm()).append(",");
//        sb.append(car.getGearType()).append(",");
//        sb.append(car.isAirCondition()).append(",");
//        sb.append(car.isCruiseControl()).append(",");
//        sb.append(car.getSeatType()).append(",");
//        sb.append(car.getSeatAmount()).append(",");
//        return sb.toString();
//    }
//    public static void saveCarToFile(Car car){
//        String carInfo = constructCarString(car);
//        FileHandler.saveToFile("Cars.txt",carInfo);
//    }