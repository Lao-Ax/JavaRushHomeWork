package com.javarush.task.task05.task0515;

/* 
Инициализация объектов

Изучи внимательно класс Person.
Исправь класс так, чтобы только один метод initialize инициализировал все переменные класса Person.
*/

public class Person {
    private String name;
    private char sex;
    private int money;
    private int weight;
    private double size;

    public void initialize(String name, char sex, int money, int weight, double size) {
        this.name = name;
        this.sex = sex;
        this.money = money;
        this.size = size;
        this.weight = weight;
    }

    public static void main(String[] args) {

    }
}
