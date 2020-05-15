package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел.
Если все три числа равны между собой, то вывести все три.

Пример для чисел 1 2 2:
2 2

Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = new int[3];
        digits[0] = Integer.valueOf(reader.readLine());
        digits[1] = Integer.valueOf(reader.readLine());
        digits[2] = Integer.valueOf(reader.readLine());
        Arrays.sort(digits);

        int[] allDigits = new int[5];
        allDigits[0] = -666;
        allDigits[4] = -666;
        for (int i = 0; i < 3; i++) {
            allDigits[i+1] = digits[i];
        }

        for (int i = 1; i < allDigits.length-1; i++) {
            if (allDigits[i] == allDigits[i-1] || allDigits[i] == allDigits[i+1]) {
                System.out.print(allDigits[i] + " ");
            }
        }
    }
}