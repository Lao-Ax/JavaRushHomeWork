package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 20;
        int[] array = new int[N];
        for (int i = 0; i < N; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(0, N-1, array);

        for (int x : array)
        {
            System.out.println(x);
        }
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
