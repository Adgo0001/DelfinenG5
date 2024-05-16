public class Finance {
    public static void checkRevenue() {
        int sum = 0;
        for(Member member : Booking.getMembers()){
            sum = sum+member.calcMemberPrice(Booking.getPriceList());
        }
        System.out.println("Årets samlede omsætning: " + sum);
    }
}
