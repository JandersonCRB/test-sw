import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    List<String> ex1(List<String> list) {
        return list.stream().map((it) -> it.substring(0, 1)).collect(Collectors.toList());
    }

    List<String> ex2(List<String> list) {
        List<String> firstOnly = list.stream().map((it) -> it.substring(0, 1)).collect(Collectors.toList());
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        return firstOnly.stream().filter(vowels::contains).collect(Collectors.toList());
    }

    List<String> ex3(List<String> list) {
        return list.stream().filter((it) -> (it.length() % 2) != 0).collect(Collectors.toList());
    }

    List<String> ex4(List<String> list) {
        new Thread(() -> list.forEach(System.out::println)).start();
        return null;
    }

    List<String> ex5(List<String> list) {
        return list.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    String ex6(List<String> list) {
        int begin = 1;
        int end = 4;
        return IntStream.range(begin, end).mapToObj(list::get).collect(Collectors.joining("-"));

    }

    public static void main(String args[]) {
    }

}
