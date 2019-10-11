import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import java.util.Arrays
import java.util.Collections

import org.junit.jupiter.api.Assertions.*

internal class MainTest {
    private val list1 = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot")
    private val list2 = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog")

    private val main = Main()

    @Test
    fun ex1() {
        var expectedResult = Arrays.asList("a", "b", "c", "d", "e", "f")
        assertEquals(expectedResult, main.ex1(list1))
        expectedResult = Arrays.asList("T", "q", "b", "f", "j", "o", "t", "l", "d")
        assertEquals(expectedResult, main.ex1(list2))
    }

    @Test
    fun ex2() {
        var expectedResult = Arrays.asList("a", "e")
        assertEquals(expectedResult, main.ex2(list1))
        expectedResult = listOf<String>("o")
        assertEquals(expectedResult, main.ex2(list2))
    }

    @Test
    fun ex3() {
        var expectedResult = Arrays.asList("alpha", "bravo", "charlie", "delta", "foxtrot")
        assertEquals(expectedResult, main.ex3(list1))
        expectedResult = Arrays.asList("The", "quick", "brown", "fox", "the", "dog")
        assertEquals(expectedResult, main.ex3(list2))
    }

    @Test
    fun ex5() {
        val expectedResult = Arrays.asList("the", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog")
        assertEquals(expectedResult, main.ex5(list2))
        assertEquals(list1, main.ex5(list1))
    }

    @Test
    fun ex6() {
        var expectedResult = "quick-brown-fox"
        assertEquals(expectedResult, main.ex6(list2))
        expectedResult = "bravo-charlie-delta"
        assertEquals(expectedResult, main.ex6(list1))
    }

    companion object {

        @BeforeAll
        fun setUpClass() {
            println("Set up class")
        }
    }
}