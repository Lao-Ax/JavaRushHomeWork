package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<Integer>();

        /*arr.add(Integer.parseInt(reader.readLine()));
        arr.add(Integer.parseInt(reader.readLine()));
        arr.add(Integer.parseInt(reader.readLine()));

        arr.sort(Comparator.<Integer>reverseOrder());

        for (Integer i : arr){
            System.out.println(i);
        }*/

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if ((a < b) && (b < c)){
            System.out.println(c);
            System.out.println(b);
            System.out.println(a);
        }
        if ((a < c) && (c < a)){
            System.out.println(b);
            System.out.println(c);
            System.out.println(a);
        }
        if ((b < a) && (a < c)){
            System.out.println(c);
            System.out.println(a);
            System.out.println(b);
        }
        if ((b < c) && (c < a)){
            System.out.println(a);
            System.out.println(c);
            System.out.println(b);
        }
        if ((c < a) && (a < b)){
            System.out.println(b);
            System.out.println(a);
            System.out.println(c);
        }
        if ((c < b) && (b < a)){
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }
}

