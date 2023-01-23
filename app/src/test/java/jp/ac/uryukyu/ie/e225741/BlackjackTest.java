package jp.ac.uryukyu.ie.e225741;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BlackjackTest {
    @Test
    void toRank(){ 
        Blackjack test = new Blackjack();
        assertEquals(test.toRank(1), "A");
        assertEquals(test.toRank(11), "J");
        assertEquals(test.toRank(12), "Q");
        assertEquals(test.toRank(10), "10");
    }
    
    
}
