package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <Key, E extends Convertable<Key>> Map<Key, E> convert(List<E> list) {
        Map<Key, E> result = new HashMap<>();
        list.forEach(item -> result.put(item.getKey(), item));
        return result;
    }
}
