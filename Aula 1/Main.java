import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static void printTitle(String title) {
        System.out.println("------" + title + "------");
    }

    private static void ex1() {
        printTitle("Exercício 1");
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> firstOnly = list.stream().map((it) -> it.substring(0, 1)).collect(Collectors.toList());
        firstOnly.forEach(System.out::println);
    }

    private static void ex2() {
        printTitle("Exercício 2");
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> firstOnly = list.stream().map((it) -> it.substring(0, 1)).collect(Collectors.toList());
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        List<String> vowelsOnly = firstOnly.stream().filter(vowels::contains).collect(Collectors.toList());
        vowelsOnly.forEach(System.out::println);
    }

    private static void ex3() {
        printTitle("Exercício 3");
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        List<String> withoutEvens = list.stream().filter((it) -> (it.length() % 2) == 0).collect(Collectors.toList());
        withoutEvens.forEach(System.out::println);
    }

    private static void ex4() {
        new Thread(() -> {
            printTitle("Exercício 4");
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            list.forEach(System.out::println);
        }).start();
    }

    private static void ex5() {
        printTitle("Exercício 5");
        List<String> list = Arrays.asList("The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");
        List<String> allLowercase = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        allLowercase.forEach(System.out::println);
    }

    private static void ex6() {
        printTitle("Exercício 6");
        List<String> list = Arrays.asList("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");
        int begin = 1;
        int end = 4;
        String result = IntStream.range(begin, end).mapToObj(list::get).collect(Collectors.joining("-"));
        System.out.println(result);
    }

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
    }
}

