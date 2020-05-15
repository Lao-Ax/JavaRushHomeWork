package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.util.Date;


/* Работа с датой
1.part1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1.part1 2013
Пример:
JANUARY 1.part1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        System.out.println(isDateOdd("JANUARY 1.part1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String str_date) throws ParseException
    {
//        char[] ch = str_date.toLowerCase().toCharArray();
//        ch[0] = Character.toUpperCase(ch[0]);
//        str_date = String.valueOf(ch);
//
//
//        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
//        LocalDate date = LocalDate.parse(str_date, formatter);
//        if (date.getDayOfYear() % 2 == 0) return false;
//        else return true;
        Date date1 = new Date(str_date);
        Date date2 = new Date(str_date);
        date1.setHours(0);
        date1.setMinutes(0);
        date1.setSeconds(0);
        date1.setDate(1);
        date1.setMonth(0);
        long msTimeDistance = date2.getTime() - date1.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int y = (int)(msTimeDistance/msDay);

        return (y % 2 == 0);
    }
}
