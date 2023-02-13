import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String phrase= "yourapp the quick brown fox jumps over the lazy dog";
        System.out.println("TOP-10 words: ");
        Arrays.stream(phrase.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(x -> System.out.println(x.getKey() + " - " + x.getValue()));

    }
}