package java8.collection.forEach;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // forEach with Map
//        Map<Integer, String> map = new HashMap<Integer, String>();
//        map.put(1, "Java");
//        map.put(2, "Javascript");
//        map.put(3, "PHP");
//        map.put(4, "C#");
//        map.put(5, "C++");
//
//        map.forEach((key, value) -> System.out.println(key + " - " + value));

        // forEach with List
        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");

        languages.forEach(lang -> {
            languages.remove(lang);
        });

    }
}
