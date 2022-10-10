package com.company;

import java.io.IOException;
import java.util.*;

public class Main {
    public static StringBuffer sortByFrequency(int arr1[], int l1) {
        Map<Integer, Integer> countMap = getCountMap(arr1, l1);
        StringBuffer result = new StringBuffer();
        countMap.entrySet().stream()

                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())

                .forEach(e -> {
                    int key = e.getKey();
                    int val = e.getValue();
                    for (int o = 0; o < val; o++) {
                        result.append(key + " ");
                    }
                });
        return result;
    }
    private static Map<Integer, Integer> getCountMap(int[] arr, int l1) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int o = 0; o < l1; o++) {
            if (countMap.containsKey(arr[o])) {
                countMap.put(arr[o], countMap.get(arr[o]) + 1);
            } else {
                countMap.put(arr[o], 1);
            }
        }
        return countMap;
    }
    public static void main(String[] args) throws IOException {

        int a[] = { 5, 5, 3, 3, -15, -15, 3,  5, 5 };

        System.out.println(sortByFrequency(a, a.length));
    }
}

