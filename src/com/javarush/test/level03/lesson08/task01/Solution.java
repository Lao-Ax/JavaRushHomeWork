package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String name;
        String sYears;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));

        sYears = reader.readLine();
        int years = Integer.parseInt(sYears);

        name = reader.readLine();

        String main_string = name + " захватит мир через " + years + " лет. Му-ха-ха!";
        System.out.print(main_string);
    }
}