package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа

Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в
исходном наборе,
в следующем виде:
«количество отрицательных чисел: а», «количество положительных чисел: б»,
где а, б — искомые значения.

Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3

Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3];
        a[0] = Integer.parseInt(reader.readLine());
        a[1] = Integer.parseInt(reader.readLine());
        a[2] = Integer.parseInt(reader.readLine());

        System.out.println("количество отрицательных чисел: " + getCountNegativeNumbers(a));
        System.out.println("количество положительных чисел: " + getCountPositiveNumbers(a));
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

    public static int getCountNegativeNumbers(int[] a) {
        int negativeCount = 0;
        for (int i : a) {
            if (i < 0) {
                negativeCount++;
            }
        }
        return negativeCount;
    }
}
