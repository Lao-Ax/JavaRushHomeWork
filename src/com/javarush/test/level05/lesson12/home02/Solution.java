package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1.part1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Vasya", 20, "Russia");
        Man man2 = new Man("Vova", 6, "Russia");

        Woman woman1 = new Woman("Tanya", 26, "Israel");
        Woman woman2 = new Woman("Lena", 10, "Russia");

        System.out.println(man1.toString());
        System.out.println(man2.toString());

        System.out.println(woman1.toString());
        System.out.println(woman2.toString());
    }

    public static class Man{
        private String name = null;
        private int age = 18;
        private String address = null;

        public Man(String name, int age, String address){
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString(){
            return name + " " + age + " " + address;
        }
    }

    public static class Woman{
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString(){
            return name + " " + age + " " + address;
        }
    }
}
