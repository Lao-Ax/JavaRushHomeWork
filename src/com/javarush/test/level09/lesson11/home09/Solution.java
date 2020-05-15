package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> cats = new HashMap<>();
        cats.put("Cat1", new Cat("Cat1"));
        cats.put("Cat2", new Cat("Cat2"));
        cats.put("Cat3", new Cat("Cat3"));
        cats.put("Cat4", new Cat("Cat4"));
        cats.put("Cat5", new Cat("Cat5"));
        cats.put("Cat6", new Cat("Cat6"));
        cats.put("Cat7", new Cat("Cat7"));
        cats.put("Cat8", new Cat("Cat8"));
        cats.put("Cat9", new Cat("Cat9"));
        cats.put("Cat10", new Cat("Cat10"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> catsNames = new HashSet<>();
        catsNames.addAll(map.values());
        return catsNames;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat " + this.name;
        }
    }


}
