package br.ufal.ic.teste.atividate.teste;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class FixedListTest {
    @Test
    void nullList() {
        List<Integer> nullList = null;
        assertThrows(NullPointerException.class, (() -> {
            FixedList<Integer> fixedList = new FixedList<>(null);
        }));
    }

    @Test
    void add() {
        List<Integer> emptyList = new ArrayList<>();
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertThrows(UnsupportedOperationException.class, (() -> {
            fixedList.add(2);
        }));
    }
    @Test
    void addAll() {
        List<Integer> emptyList = new ArrayList<>();
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertThrows(UnsupportedOperationException.class, (() -> {
            fixedList.addAll(emptyList);
        }));
    }

    @Test
    void clear() {
        List<Integer> emptyList = new ArrayList<Integer>();
        emptyList.add(2);
        emptyList.add(6);
        emptyList.add(1);
        emptyList.add(3);
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertThrows(UnsupportedOperationException.class, (() -> {
            fixedList.addAll(emptyList);
        }));
    }


    @Test
    void indexOf() {
        List<Integer> emptyList = new ArrayList<>();
        emptyList.add(2);
        emptyList.add(6);
        emptyList.add(1);
        emptyList.add(3);
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        fixedList.lastIndexOf(6);
        assertEquals(fixedList.lastIndexOf(6), 1);
    }

    @Test
    void get() {
        List<Integer> emptyList = new ArrayList<>();
        emptyList.add(2);
        emptyList.add(6);
        emptyList.add(1);
        emptyList.add(3);
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertEquals(fixedList.get(2), 1);
    }

    @Test
    void remove() {
        List<Integer> emptyList = new ArrayList<>();
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertThrows(UnsupportedOperationException.class, (() -> {
            fixedList.remove(1);
        }));
        assertThrows(UnsupportedOperationException.class, (() -> {
            fixedList.remove(new Integer(2));
        }));
    }

    @Test
    void set() {
        List<Integer> emptyList = new ArrayList<>();
        emptyList.add(2);
        emptyList.add(6);
        emptyList.add(1);
        emptyList.add(3);
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        fixedList.set(2, 99);
        assertEquals(fixedList.get(2), 99);
    }

    @Test
    void shouldBeEmpty() {
        List<Integer> emptyList = new ArrayList<>();
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertTrue(fixedList.isEmpty());
    }

    @Test
    void shouldNotBeEmpty() {
        List<Integer> emptyList = new ArrayList<>();
        emptyList.add(2);
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertFalse(fixedList.isEmpty());
    }

    @Test
    void size() {
        List<Integer> emptyList = new ArrayList<>();
        emptyList.add(2);
        FixedList<Integer> fixedList = new FixedList<>(emptyList);
        assertEquals(fixedList.size(), 1);
    }
}