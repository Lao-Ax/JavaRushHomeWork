package com.javarush.test.level06.lesson05.task04;

/* Cчётчик котов
В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную этого же класса catCount) на 1.part1. В методе finalize уменьшать на 1.part1.
*/

public class Cat
{
    public static int catCount = 0;

    public Cat(){
        catCount++;
    }

    public static void main(String[] args) throws Throwable{
//        System.out.println(catCount);
//        Cat cat = new Cat();
//        System.out.println(catCount);
//        cat.finalize();
//        System.out.println(catCount);
    }

    @Override
    public void finalize() throws Throwable{
        super.finalize();
        catCount--;
    }
}
