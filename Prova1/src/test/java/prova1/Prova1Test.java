package prova1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class Prova1Test {

    private static TreeSet<Integer> ts;

    @BeforeEach
    void resetTs() {
        ts = new TreeSet<Integer>();
    }

    @Test
    void testAdd() {
        Integer mockValue = 2;
        assertFalse(ts.contains(mockValue));
        ts.add(mockValue);
        assertTrue(ts.contains(mockValue));
    }

    @Test
    void testCeiling() {
        List<Integer> mockValues = Arrays.asList(5, 3, 10, 2, 2, 30, 999);
        ts.addAll(mockValues);
        assertEquals(30, ts.ceiling(30));
        assertEquals(999, ts.ceiling(31));
        assertEquals(999, ts.ceiling(999));
        assertEquals(2, ts.ceiling(1));
        assertNull(ts.ceiling(1000));
    }

    @Test
    void testClear() {
        List<Integer> mockValues = Arrays.asList(5, 3, 10, 2, 2, 30, 999);
        ts.clear();
        // Assert that each value of our list is not in the set
        mockValues.forEach(v -> assertFalse(ts.contains(v)));

        // Down here we check if it doesn't mess with other values
        assertFalse(ts.contains(0));
        assertFalse(ts.contains(Integer.MAX_VALUE));
        assertFalse(ts.contains(Integer.MIN_VALUE));

    }

    @Test
    void testClone() {
        List<Integer> mockValues = Arrays.asList(5, 3, 10, 2, 2, 30, 999);
        ts.addAll(mockValues);
        TreeSet<Integer> tsClone = (TreeSet) ts.clone();
        tsClone.clear();
        mockValues.forEach(v -> {
            assertTrue(ts.contains(v));
            assertFalse(tsClone.contains(v));
        });
    }

}