package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private String adress = null;
    private String color = null;
    private int age = 1;
    private int weight = 3;

    public void initialize(String name)
    {
        this.name = name;
//        this.weight
    }

    public void initialize(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void initialize(String name, int age)
    {
        this.name = name;
        this.weight = 3;
        this.age = age;
    }

    // вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
    public void initialize(int weight, String color)
    {
        this.color = color;
        this.weight = weight;
    }

    // вес, цвет, адрес ( чужой домашний кот)
    public void initialize(int weight, String color, String adress)
    {
        this.weight = weight;
        this.color = color;
        this.adress = adress;
    }
}