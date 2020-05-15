package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» — если число отрицательное и четное,
«отрицательное нечетное число» — если число отрицательное и нечетное,
«ноль» — если число равно 0,
«положительное четное число» — если число положительное и четное,
«положительное нечетное число» — если число положительное и нечетное.

Пример для числа 100:
положительное четное число

Пример для числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        StringBuilder desc = new StringBuilder();

        if (a == 0) {
            desc.append("ноль");
        } else {
            if (a < 0) {
                desc.append("отрицательное ");
            } else if (a > 0) {
                desc.append("положительное ");
            }

            if (a % 2 == 0) {
                desc.append("четное ");
            } else {
                desc.append("нечетное ");
            }

            desc.append("число");
        }

        System.out.println(desc.toString());
    }
}
