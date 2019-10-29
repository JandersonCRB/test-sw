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
        ts = new TreeSet<>();
    }


    /**
     * This method simply adds the value 2 and check if
     * it's inserted in TreeSet using contains method
     */
    @Test
    void testAdd() {
        Integer mockValue = 2;
        assertFalse(ts.contains(mockValue));
        ts.add(mockValue);
        assertTrue(ts.contains(mockValue));
    }


    /**
     * Test if add method throws NullPointerException while
     * trying to add a null value to set
     */
    @Test
    void testAddNull() {
        assertThrows(NullPointerException.class, () -> ts.add(null));
    }

    /**
     * Tests if ceiling method is correctly returning what it's expected to
     */
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

    /**
     * Test if ceiling method works well with min/max values
     */
    @Test
    void testCeilingLimits() {
        ts.add(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, ts.ceiling(Integer.MIN_VALUE));
        ts.add(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, ts.ceiling(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, ts.ceiling(0));
    }

    /**
     * Testing if clear method is properly working
     */
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

    /**
     * Testing if clone method is properly working
     */
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

    /**
     * Test if contains method is working by adding a mock value and
     * checking if contains return the expected result
     */
    @Test
    void testContains() {
        Integer mockValue = 2;
        assertFalse(ts.contains(mockValue));
        ts.add(mockValue);
        assertTrue(ts.contains(mockValue));
    }

    /**
     * Testing is contains properly throws a NullPointsException
     */
    @Test
    void testContainsNull() {
        assertThrows(NullPointerException.class, () -> ts.contains(null));
    }

    /**
     * Testing if last method properly returns the highest element
     */
    @Test
    void testLast() {
        ts.add(2);
        assertEquals(2, ts.last());
        ts.add(0);
        assertEquals(2, ts.last());
        ts.add(20);
        assertEquals(20, ts.last());
        ts.add(-25);
        assertEquals(20, ts.last());
    }

    /**
     * Testing if remove method is working by adding and removing a value
     * and checking if it was removed using contains
     */
    @Test
    void testRemove() {
        Integer mockValue = 2;
        ts.add(mockValue);
        ts.remove(mockValue);
        assertFalse(ts.contains(mockValue));
    }
}