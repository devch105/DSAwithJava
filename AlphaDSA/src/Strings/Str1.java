package Strings;

import java.util.Comparator;
import java.util.List;

public class Str1 {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Comparator", "Kubernetes", "Docker", "Microservices");

        String longest = words.stream().max(Comparator.comparingInt(String::length)).orElse("");

        String longest2 = words.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst()
                .orElse("");

        System.out.println("Longest String is : " + longest);
        System.out.println("Longest String is : " + longest2);

    }
}
