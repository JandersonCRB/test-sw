package prova1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class Prova1Test {

    static TreeSet<String> ts;

    @BeforeEach
    void resetTs() {
        ts = new TreeSet<String>();
    }

    @Test
    void testAdd() {
        String mockValue = "2";
        assertFalse(ts.contains(mockValue));
        ts.add(mockValue);
        assertTrue(ts.contains(mockValue));
    }

}