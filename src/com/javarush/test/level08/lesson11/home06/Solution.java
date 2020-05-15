package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1.part1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args)
    {
        List<Human> list = new ArrayList<>();
        list.add(new Human("Дед1", true, 60, null));
        list.add(new Human("Дед2", true, 80, null));
        list.add(new Human("Баб1", false, 60, null));
        list.add(new Human("Баб2", false, 80, null));
        list.add(new Human("Отец", true, 25, list.get(0), list.get(2)));
        list.add(new Human("Мать", false, 26, list.get(1), list.get(3)));
        list.add(new Human("Реб1", true, 4, list.get(4), list.get(5)));
        list.add(new Human("Реб2", true, 8, list.get(4), list.get(5)));
        list.add(new Human("Реб3", true, 12, list.get(4), list.get(5)));

        for (Human h : list)
            System.out.println(h);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, Human... humans){
            this.name = name;
            this.sex = sex;
            this.age = age;

            if (humans != null) {
                children = new ArrayList<Human>();
                for (Human h : humans) {
                    children.add(h);
                }
            }
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = 0;
            if (children != null) childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
