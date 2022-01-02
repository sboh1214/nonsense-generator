package com.jasofalcon.nonsensegenerator.data;

import java.util.List;
import java.util.Random;

public class Conjunctions {
    public static String get() {
        Random r = new Random();
        return words.get(r.nextInt(words.size()));
    }

    private static final List<String> words = List.of("if","and", "when", "after", "before", "because", "while", "since", "until");
}
