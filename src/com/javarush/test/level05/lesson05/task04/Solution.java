package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/

public class Solution {
    public static void main(String[] args) {
        Cat firstLittleCat = new Cat("Барсик", 1, 5, 10);
        System.out.println(firstLittleCat.toString());
        Cat secondLittleCat = new Cat("Васька", 2, 8, 12);
        System.out.println(secondLittleCat.toString());
        Cat thirdLittleCat = new Cat("Рыжик", 3, 12, 7);
        System.out.println(thirdLittleCat.toString());
    }

    public static class Cat {

        public static int count = 0;
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            count++;

            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        @Override
        public String toString(){
            return this.name + this.age + this.strength + this.weight + "; count = " + count;
        }
    }
}
