package com.github.common;

import java.util.Comparator;
import java.util.List;

public class Utils {
    public static boolean isSortedDes(List<Double> list) {
        return list.stream().sorted(Comparator.reverseOrder()).toList().equals(list);
    }
}
