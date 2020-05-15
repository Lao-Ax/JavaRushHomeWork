package com.javarush.test.level09.lesson11.home05;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1.part1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

public class Solution
{
    public static Character[] vowels = new Character[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception
    {
        HashSet<Character> setOfVowels = new HashSet<>();
        Collections.addAll(setOfVowels, vowels);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        String str_vowels = "";
        String str_else = "";

        for (int i = 0; i < str.length(); i++) {
            if (setOfVowels.contains(Character.toLowerCase(str.charAt(i))))
                str_vowels += str.charAt(i) + " ";
            else if (str.charAt(i) != ' ') str_else += str.charAt(i) + " ";
        }

        System.out.println(str_vowels);
        System.out.println(str_else);

    }
}
