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
        for(Member member : Booking.getMembers()) {
            if(member.getRestance()) {
                System.out.println("------------------------------");
                System.out.println(member);
            }
        }
    }
}
