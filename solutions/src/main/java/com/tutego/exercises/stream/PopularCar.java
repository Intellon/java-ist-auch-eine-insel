package com.tutego.exercises.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PopularCar {
    public static void main(String[] args) {
        String[] cars = {
                "Gurkha RPV", "Mercedes-Benz G 63 AMG", "BMW 750", "Toyota Land Cruiser",
                "Mercedes-Benz G 63 AMG", "Volkswagen T5", "BMW 750", "Gurkha RPV", "Dartz Prombron",
                "Marauder", "Gurkha RPV"};
        Map<String, Long> map = Arrays.stream(cars)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.entrySet().removeIf(stringLongEntry -> stringLongEntry.getValue() < 2);
        System.out.println(map);

        Collector<Object, long[], Boolean> collector = Collector.of(
                () -> new long[1], // Supplier<A> supplier
                (a, t) -> a[0]++,  // BiConsumer<A,T> accumulator
                (a, b) -> {        // BinaryOperator<A> combiner
                    a[0] += b[0];
                    return a;
                },
                a -> a[0] > 1);    // Function<A,R> finisher

        Map<String, Boolean> map2 = Arrays.stream(cars)
                .collect(Collectors.groupingBy(Function.identity(), collector));
        System.out.println(map2);

    }
}
