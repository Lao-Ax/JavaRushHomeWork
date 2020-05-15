package com.javarush.test.level10.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: ввести с клавиатуры 30 чисел. Вывести 10-е и 11-е минимальные числа.
Пояснение:
Самое минимальное число – 1.part1-е минимальное.
Следующее минимальное после него – 2-е минимальное
Пример:
1.part1 6 5  7  1.part1  15   63   88
Первое минимальное – 1.part1
Второе минимальное – 1.part1
Третье минимальное – 5
Четвертое минимальное – 6
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {   int N = 30;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[N];
        for (int i = 0; i < N; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array)
    {
        quickSort(0,array.length-1,array);
    }

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
