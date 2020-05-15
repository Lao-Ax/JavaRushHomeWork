package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {   int age = 0;
        String name;
        String surname;
        String patronymic = null;
        Date birthDate = null;
        boolean sex;

        private SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

        public Human(String name, String surname, boolean sex){
            this.name = name;
            this.surname = surname;
            this.sex = sex;
        }

        public Human(String name, String surname, String patronymic, boolean sex){
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.sex = sex;
        }

        public Human(int age){
            this.age = age;
        }

        public Human(String birthDate) throws ParseException {
            this.birthDate = sdf.parse(birthDate);
        }

        public Human(String name, String surname, String patronymic, String birthDate, boolean sex) throws ParseException {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
            this.sex = sex;
            this.birthDate = sdf.parse(birthDate);
        }

        public Human(String name, String birthDate) throws ParseException {
            this.name = name;
            this.birthDate = sdf.parse(birthDate);
        }

        public Human(int age, boolean sex){
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, String name){
            this.age = age;
            this.name = name;
        }

        public Human(String name, Date birthDate) throws ParseException {
            this.name = name;
            this.birthDate = birthDate;
        }

        public Human(boolean sex, Date birthDate) throws ParseException {
            this.sex = sex;
            this.birthDate = birthDate;
        }
    }
}
