package com.github.common;

import java.util.List;

public class Utils {
    public static boolean isSorted(List<Double> list) {
        return list.stream().sorted().toList().equals(list);
    }
}
