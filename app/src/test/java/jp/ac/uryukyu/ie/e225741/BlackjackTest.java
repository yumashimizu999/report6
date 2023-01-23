package jp.ac.uryukyu.ie.e225741;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BlackjackTest {
    @Test
    void toRank(){ 
        Blackjack test = new Blackjack();
        assertEquals(Blackjack.toRank(1), "A");
        assertEquals(Blackjack.toRank(11), "J");
        assertEquals(Blackjack.toRank(12), "Q");
        assertEquals(Blackjack.toRank(10), "10");
    }
    
    
}
