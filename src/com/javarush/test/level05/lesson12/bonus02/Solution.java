package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        arr[0] = Integer.parseInt(reader.readLine());
        arr[1] = Integer.parseInt(reader.readLine());
        arr[2] = Integer.parseInt(reader.readLine());
        arr[3] = Integer.parseInt(reader.readLine());
        arr[4] = Integer.parseInt(reader.readLine());

        quickSort(0, arr.length - 1, arr);

        System.out.println("Minimum = " + min(arr));
    }

    public static int min(int arr[])
    {
        return arr[0];
    }

    /**
     * Алгоритм быстрой сортировки с рекурсией.
     * @param L - левая граница диапазона сортировки
     * @param R - правая граница диапазона сортировки
     */
    private static void quickSort(int L, int R, int[] arr) throws NullPointerException {
        if (arr.length == 0) throw new NullPointerException();
        int i = L, j = R;							      // запоминаем левую и правую границы в переменные
        int x = arr[(L+R)/2];                             // выбираем первый элемент для соритровки "случайно"
        do{											      // сортировка имеет смысл, пока границы не сойдутся => условие i<j
            while (arr[i] < x)                            // ищем первый индекс элемента, который больше х, но левее него.
                i++;
            while (x < arr[j])                            // ищем первый индекс элемента, который меньше х, но правее него.
                j--;
            if (i <= j){							      // если они по разные стороны, то их надо поменять местами
                int buf = arr[i];
                arr[i] = arr[j];
                arr[j] = buf;
                i++;								      // и двигаем границы
                j--;
            }
        } while (i < j);
        if (L < j) quickSort(L, j, arr);             // делаем то же самое для половинок. В эти условия не зайдем, если
        if (i < R) quickSort(i, R, arr);			 // только если достигли границ диапазона.
    }
}
