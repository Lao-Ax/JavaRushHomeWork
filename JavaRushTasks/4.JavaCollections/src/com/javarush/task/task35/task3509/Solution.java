package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
//        ArrayList<Integer> list = newArrayList(1, 2, 3, 4);
//        HashSet<Integer> set = newHashSet(1, 2, 3);
//        HashMap<String, Integer> map = newHashMap(Arrays.asList("a", "b"), Arrays.asList(1, 2));
//        System.out.println(list.size() + " :: " + set.size()  + " :: " + map.size());
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) throws IllegalArgumentException {
        if (keys.size() != values.size()) throw new IllegalArgumentException();
        HashMap<K, V> map = new HashMap<>();
        Iterator<? extends K> keyIt = keys.iterator();
        Iterator<? extends V> valIt = values.iterator();
        while (keyIt.hasNext() && valIt.hasNext()) {
            map.put(keyIt.next(), valIt.next());
        }

        return map;
    }
}
