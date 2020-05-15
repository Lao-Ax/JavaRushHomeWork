package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        Set<String> nameSet = new HashSet<>();
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (nameSet.contains(pair.getValue()))
                removeItemFromMapByValue(map, pair.getValue());
            nameSet.add(pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        SomeClass m = new SomeClass("5");
        SomeClass n = new SomeClass("6");

        System.out.println("M=" + m + " N=" + n);
        swap(m, n);
        System.out.println("M=" + m + " N=" + n);
    }

    private static void swap(SomeClass m, SomeClass n) {
        SomeClass c = new SomeClass("");
        c.name = m.name;
        m.name = n.name;
        n.name = c.name;
        m = new SomeClass("KOshka");
    }

    static class SomeClass{
        String name;

        public SomeClass(String s){
            this.name = s;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

}
