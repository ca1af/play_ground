package com.example.play_ground.java.enumPrac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypeParameters {
    public static <T extends Number> long sumWildcard(List<T> numbers) {
        return numbers.stream().mapToLong(Number::longValue).sum();
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(10);
        long l = sumWildcard(integers);
        System.out.println(l);
    }
}
