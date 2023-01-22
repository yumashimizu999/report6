package jp.ac.uryukyu.ie.e225741;

import java.beans.Transient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BlackjackTest {
    @Test
    void toRank(){
        assertEquals(toRank(1), A);
        assertEquals(toRank(11), J);
        assertEquals(toRank(12), Q);
        assertEquals(toRank(10), 10);
    }
    
    
}
