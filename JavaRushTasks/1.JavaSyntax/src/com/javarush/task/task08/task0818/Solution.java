package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Только для богачей

Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alex 1", 10);
        map.put("Mia 2", 11);
        map.put("Luiza 3", 12);
        map.put("Rob 4", 13);
        map.put("Mary 5", 1400);
        map.put("Rolsen 6", 15);
        map.put("Anton 7", 106);
        map.put("Udjin 8", 1000);
        map.put("Ulrik 9", 108);
        map.put("Kostya 10", 1);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
//        HashMap<String, Integer> newMap = new HashMap<>(map);
//        newMap.entrySet().stream().filter(pair -> pair.getValue() < 500).forEach(pair -> {
//            map.remove(pair.getKey());
//        });
//        HashMap<String, Integer> newMap = new HashMap<>(map);
//        for (Map.Entry<String, Integer> pair : newMap.entrySet()) {
//            if(pair.getValue() < 500) {
//                map.remove(pair.getKey());
//            }
//        }
        map.entrySet().removeIf(entry -> entry.getValue() < 500);
    }

    public static void main(String[] args) {
    }
}