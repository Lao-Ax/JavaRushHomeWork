package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args){
        HashMap<String, String> map = createMap();
        System.out.println(getCountTheSameFirstName(map, "Илья"));
        System.out.println(getCountTheSameLastName(map, "Иванов"));
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Илья");
        map.put("Петров", "Алексей");
        map.put("Сидоров", "Сергей");
        map.put("Курочкин", "Илья");
        map.put("Петухов", "Алексей");
        map.put("Козлов", "Сергей");
        map.put("Голубев", "Илья");
        map.put("Березкин", "Алексей");
        map.put("Дубов", "Сергей");
        map.put("Липов", "Матвей");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int counter = 0;
        for (Map.Entry<String, String> fn : map.entrySet()) if (fn.getValue().equals(name)) counter++;
        return counter;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int counter = 0;
        for (Map.Entry<String, String> fn : map.entrySet()) if (fn.getKey().equals(familiya)) counter++;
        return counter;
    }
}
