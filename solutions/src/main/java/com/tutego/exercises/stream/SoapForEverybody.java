package com.tutego.exercises.stream;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SoapForEverybody {
    public static void main(String[] args) {

        class Soap {
            final int size = ThreadLocalRandom.current().nextInt(2, 5);

            public String toString() {
                return "" + size;
            }
        }

        String names = "Peter, Paul, Sven";
        Map<String, Soap> cakeMap =
                Pattern.compile("\\s*,\\s*").splitAsStream(names)
                        .collect(Collectors.toMap(Function.identity(), __ -> new Soap()));
        System.out.println(cakeMap);
    }
}
