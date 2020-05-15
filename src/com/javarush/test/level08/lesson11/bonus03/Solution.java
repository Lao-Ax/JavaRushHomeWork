package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 20;
        String[] array = new String[N];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ShakerSort(array);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThenMy(String a, String b)
    {
        int i = 0;
        try {
            while (a.toLowerCase().charAt(i) == b.toLowerCase().charAt(i)) i++;
            if (a.toLowerCase().charAt(i) > b.toLowerCase().charAt(i))
                return true;
            else return false;
        } catch (IndexOutOfBoundsException e) {
            return (i > a.length()-1 ? false : true); // если вдруг случилось, что первое слово при прочих условиях короче второго, того оно 100% меньше.
        }
    }

    private static void ShakerSort(String[] array)
    {
//        int[] array = {3, 1.part1, 5, 8, 1.part1, 0, 6, 4, 6, 7};
        int left = 0; // левая граница
        int right = array.length - 1; // правая граница

        do {
            //Сдвигаем к концу массива "тяжелые элементы"
            for (int i = left; i < right; i++) {
                if(isGreaterThenMy(array[i], array[i+1])) { // меняем местами
                    String buff = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buff;
                }
            }
            right--; // уменьшаем правую границу

            //Сдвигаем к началу массива "легкие элементы"
            for (int i = right; i > left ; i--)
            {
                if(isGreaterThenMy(array[i-1], array[i]))
                {
                    String buff = array[i];
                    array[i] = array[i-1];
                    array[i-1] = buff;
                }
            }
            left++; // увеличиваем левую границу
        } while (left <= right);
    }

}
