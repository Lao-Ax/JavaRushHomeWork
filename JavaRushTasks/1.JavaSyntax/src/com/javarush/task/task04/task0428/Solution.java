package com.javarush.task.task04.task0428;

/* 
Положительное число
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.

Пример для чисел -4 6 6:
2

Пример для чисел -6 -6 -3:
0
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        a[0] = Integer.parseInt(reader.readLine());
        a[1] = Integer.parseInt(reader.readLine());
        a[2] = Integer.parseInt(reader.readLine());

        System.out.println(getCountPositiveNumbers(a));
    }

    public static int getCountPositiveNumbers(int[] a) {
        int positiveCount = 0;
        for (int i : a) {
            if (i > 0) {
                positiveCount++;
            }
        }
        return positiveCount;
    }
}
