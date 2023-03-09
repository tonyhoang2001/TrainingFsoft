package java8.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional o = Optional.of(null);
        System.out.println(o);

//        String[] words = new String[10];
//        words[0] = "abc";
//        java.util.Optional<String> checkNull
//                = java.util.Optional.ofNullable(words[8]);
//        String s = checkNull.orElseThrow();
//        System.out.println(s);
//
//        if (checkNull.isPresent()) {
//            String word = words[5].toLowerCase();
//            System.out.print(word);
//        }
//        else
//            System.out.println("word is null");
//
//        // creating a string array
//        String[] str = new String[5];
//
//        // Setting value for 2nd index
//        str[2] = "Geeks Classes are coming soon";
//
//        // It returns an empty instance of Optional class
//        java.util.Optional<String> empty = java.util.Optional.empty();
//        System.out.println(empty);
//
//        // It returns a non-empty Optional
//        java.util.Optional<String> value = java.util.Optional.of(str[2]);
//        System.out.println(value);
    }
}
