package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    static int[] alphabet_ = new int[34];

    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add((char) ('а' + i));
        }
        alphabet.add(6, 'ё');

        // зануление алфавита
        for (int i = 0; i < alphabet_.length; i++) alphabet_[i] = 0;


        //ввод строк
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine().toLowerCase();
            for (int ii = 0; ii < s.length(); ii++)
                incLetterCounter(s.charAt(ii));
        }

        for (Character ch : alphabet) {
            System.out.print(ch + " ");
            System.out.println(alphabet_[(int) ch - 1072]);
        }
    }

    public static void incLetterCounter(char ch){
        if (ch == ' ') return;
        int a = 1072;
        alphabet_[(int) ch - a]++;
    }
}
