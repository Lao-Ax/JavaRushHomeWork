package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(0, array.length-1, array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int L, int R, int[] arr) throws NullPointerException
    {
        if (arr.length == 0) throw new NullPointerException();
        int i = L, j = R;							      // запоминаем левую и правую границы в переменные
        int x = arr[(L+R)/2];                             // выбираем первый элемент для соритровки "случайно"
        do{											      // сортировка имеет смысл, пока границы не сойдутся => условие i<j
            while (arr[i] > x)                            // ищем первый индекс элемента, который больше х, но левее него.
                i++;
            while (x > arr[j])                            // ищем первый индекс элемента, который меньше х, но правее него.
                j--;
            if (i <= j){							      // если они по разные стороны, то их надо поменять местами
                int buf = arr[i];
                arr[i] = arr[j];
                arr[j] = buf;
                i++;								      // и двигаем границы
                j--;
            }
        } while (i < j);
        if (L < j) sort(L, j, arr);             // делаем то же самое для половинок. В эти условия не зайдем, если
        if (i < R) sort(i, R, arr);			    // только если достигли границ диапазона.
    }
}
