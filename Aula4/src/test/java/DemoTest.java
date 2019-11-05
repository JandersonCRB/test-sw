import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class DemoTest {

    @Test
    void testArray() {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        assertThat(arr1, equalTo(arr2));
    }

    @Test
    void diffObj() {
        Demo d1 = new Demo("Janderson", 1);
        Demo d2 = new Demo("Janderson", 2);
        assertThat(d1, not(equalTo(d2)));
    }

    @Test
    void equalObj() {
        Demo d1 = new Demo("Janderson", 1);
        Demo d2 = new Demo("Janderson", 1);
        assertThat(d1, equalTo(d2));
    }

    @Test
    void computString() {
        String comput = "computação";
        assertThat(comput, containsString("o"));
        assertThat(comput, containsString("ta"));
    }

    @Test
    void testList() {
        List<String> myList = new ArrayList<>();
        myList.add("um");
        myList.add("dois");
        myList.add("três");
        myList.add("quatro");
        assertThat(myList, hasItem("dois"));
        assertThat(myList, hasItem("quatro"));
    }

    @Test
    void computStringStartsWith() {
        String comput = "computação";
        assertThat(comput, equalTo("computação"));
        assertThat(comput, startsWith("comput"));
    }

    @Test
    void testInstString() {
        String inst = "instituto";

        assertThat(inst, not(equalTo("matemática")));
        assertThat(inst, not(equalTo("física")));

        assertThat(inst, anyOf(
                equalTo("matemática"),
                equalTo("instituto")
        ));
    }

    @Test
    void testInt() {
        Integer testInt = 7;
        assertThat(testInt, not(
                allOf(
                        equalTo(3),
                        equalTo(4)
                )
                )
        );
    }

    @Test
    void testInstance() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertThat(obj1, not(sameInstance(obj2)));

        Demo d1 = new Demo("same name", 0);
        Demo d2 = new Demo("same name", 0);
        assertThat(d1, not(sameInstance(d2)));
    }

    @Test
    void allHasA() {
        List<String> txtList = new ArrayList<>();
        txtList.add("alagoas");
        txtList.add("acre");
        txtList.add("paraná");
        assertThat(txtList, everyItem(containsString("a")));
    }
}