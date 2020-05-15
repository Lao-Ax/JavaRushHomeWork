package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> listOfHumans = new ArrayList<>();
        listOfHumans.add(new Human("Дед1", true, 63, null, null));
        listOfHumans.add(new Human("Дед2", true, 68, null, null));
        listOfHumans.add(new Human("Баб1", false, 65, null, null));
        listOfHumans.add(new Human("Баб2", false, 72, null, null));
        listOfHumans.add(new Human("Father", true, 28, listOfHumans.get(0), listOfHumans.get(2)));
        listOfHumans.add(new Human("Mother", false, 26, listOfHumans.get(1), listOfHumans.get(3)));
        listOfHumans.add(new Human("Дет1", true, 5, listOfHumans.get(4), listOfHumans.get(5)));
        listOfHumans.add(new Human("Дет2", false, 10, listOfHumans.get(4), listOfHumans.get(5)));
        listOfHumans.add(new Human("Дет3", true, 8, listOfHumans.get(4), listOfHumans.get(5)));

        for (Human h : listOfHumans)
            System.out.print(h.toString());
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text+"\n";
        }
    }

}
