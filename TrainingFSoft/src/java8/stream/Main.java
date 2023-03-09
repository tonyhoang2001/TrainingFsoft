package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(23, -1, 4, 0);

        List<Integer> square = number.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());

        List<Integer> sortedList = number.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(number);
        System.out.println(square);
        System.out.println(sortedList);
//
//
//        List<String> names = Arrays.asList("Reflection","Collection","Stream");
//        List<String> startWithS = names.stream()
//                .filter(n -> n.startsWith("S"))
//                .collect(Collectors.toList());
//        System.out.println(startWithS);

    }
}
