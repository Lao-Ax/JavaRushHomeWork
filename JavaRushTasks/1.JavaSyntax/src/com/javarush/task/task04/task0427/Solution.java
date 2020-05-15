package com.javarush.task.task04.task0427;

/* 
Описываем числа
Ввести с клавиатуры целое число в диапазоне 1 — 999. Вывести его строку-описание следующего вида:
«четное однозначное число» — если число четное и имеет одну цифру,
«нечетное однозначное число» — если число нечетное и имеет одну цифру,
«четное двузначное число» — если число четное и имеет две цифры,
«нечетное двузначное число» — если число нечетное и имеет две цифры,
«четное трехзначное число» — если число четное и имеет три цифры,
«нечетное трехзначное число» — если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 — 999, в таком случае ничего не выводить на экран.

Пример для числа 100:
четное трехзначное число

Пример для числа 51:
нечетное двузначное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        desc(a);
    }

    public static void desc(int a) {
        StringBuilder desc = new StringBuilder();

        if (a < 1 || a > 999) {
            // ignore
        } else {
            if (a % 2 == 0) {
                desc.append("четное ");
            } else {
                desc.append("нечетное ");
            }

            if (a < 10) {
                desc.append("однозначное ");
            } else if (a < 100) {
                desc.append("двузначное ");
            } else {
                desc.append("трехзначное ");
            }

            desc.append("число");
            System.out.println(desc.toString());
        }
    }
}
