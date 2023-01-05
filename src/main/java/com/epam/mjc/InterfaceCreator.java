package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String word : x) {
                if (Character.isDigit(word.charAt(0)) || Character.isLowerCase(word.charAt(0))) {
                    return false;
                }
            }

            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            ArrayList<Integer> evenNums = new ArrayList<>();

            x.forEach(val -> {
                if (val % 2 == 0) {
                    evenNums.add(val);
                }
            });

            x.addAll(evenNums);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            ArrayList<String> filtered = new ArrayList<>();

            values.forEach(val -> {
                if (Character.isUpperCase(val.charAt(0)) && val.charAt(val.length() - 1) == '.' && val.split(" ").length > 3) {
                    filtered.add(val);
                }
            });

            return filtered;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            HashMap<String, Integer> sizeOfValues = new HashMap<>();

            x.forEach(val -> sizeOfValues.put(val, val.length()));

            return sizeOfValues;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (first, second) -> {
            first.addAll(second);
            return new ArrayList<>(first);
        };
    }
}
