public class Finance {
    public static void checkRevenue() {
        int sum = 0;
        for(Member member : Booking.getMembers()){
            sum = sum+member.calcMemberPrice(Booking.getPriceList());
        }
        System.out.println("Årets samlede omsætning: " + sum);
    }

    public static void printMembersInRestance() {
        System.out.println("Medlemmer i restance: ");
        boolean blank = true;
        for(Member member : Booking.getMembers()) {
            if(member.getRestance()) {
                System.out.println("------------------------------");
                System.out.println(member);
                blank = false;
            }
        }
        if (blank) {
            System.out.println("Der er ingen medlemmer i restance.");
        }
    }
}


// while (input.hasNextLine()) {
//       String line = input.nextLine();
//       Scanner lineScan = new Scanner(line);
//
//       int number = lineScan.nextInt();
//       String something = lineScan.next();
//       String svømmedicipliner = "";
//       while (lineScan.hasNext() && !lineScan.hasNextInt()) {
//           somethings2 += lineScan.next();
//       }