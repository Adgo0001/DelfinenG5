import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void calcMemberPrice() {
        // Tester når medlemmet er pensionist og aktivt
        Member member1 = new Member("Ali",19191919,true,200);
        int[] priceList = {500, 1000, 1600, 1200};
        Assertions.assertEquals(1200, member1.calcMemberPrice(priceList));

        // Tester når medlemmet er junior og aktivt
        Member member2 = new Member("Ali",19191919,true,2020);
        Assertions.assertEquals(1000, member2.calcMemberPrice(priceList));

        // Tester når medlemmet er inaktivt
        Member member3 = new Member("Ali",19191919,false,1990);
        Assertions.assertEquals(500, member3.calcMemberPrice(priceList));

        // Tester når medlemmet er senior og aktivt
        Member member4 = new Member("Ali",19191919,true,1990);
        Assertions.assertEquals(1600, member4.calcMemberPrice(priceList));
    }
}