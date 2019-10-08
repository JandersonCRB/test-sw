import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final List<String> list1 = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
    private final List<String> list2 =
            Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    private final Main main = new Main();

    @Test
    void ex1() {
        List<String> expectedResult = Arrays.asList("a", "b", "c", "d", "e", "f");
        assertEquals(expectedResult, main.ex1(list1));
        expectedResult = Arrays.asList("T", "q", "b", "f", "j", "o", "t", "l", "d");
        assertEquals(expectedResult, main.ex1(list2));
    }

    @Test
    void ex2() {
        List<String> expectedResult = Arrays.asList("a", "e");
        assertEquals(expectedResult, main.ex2(list1));
        expectedResult = Collections.singletonList("o");
        assertEquals(expectedResult, main.ex2(list2));
    }

    @Test
    void ex3() {
        List<String> expectedResult = Arrays.asList("alpha", "bravo", "charlie",  "delta", "foxtrot");
        assertEquals(expectedResult, main.ex3(list1));
        expectedResult = Arrays.asList("The", "quick", "brown", "fox", "the", "dog");
        assertEquals(expectedResult, main.ex3(list2));
    }

    @Test
    void ex5() {
        List<String> expectedResult =
                Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        assertEquals(expectedResult, main.ex5(list2));
        assertEquals(list1, main.ex5(list1));
    }

    @Test
    void ex6() {
        String expectedResult = "quick-brown-fox";
        assertEquals(expectedResult, main.ex6(list2));
        expectedResult = "bravo-charlie-delta";
        assertEquals(expectedResult, main.ex6(list1));
    }
}