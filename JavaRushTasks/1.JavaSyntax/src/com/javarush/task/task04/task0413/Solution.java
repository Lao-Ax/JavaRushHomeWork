package com.javarush.task.task04.task0413;

/* 
День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название
«понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше 7 или меньше 1 – вывести «такого дня недели не существует».

Пример для номера 5:
пятница

Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.valueOf(reader.readLine());

        String s;

        switch (a) {
            case 1: s = "понедельник"; break;
            case 2: s = "вторник"; break;
            case 3: s = "среда"; break;
            case 4: s = "четверг"; break;
            case 5: s = "пятница"; break;
            case 6: s = "суббота"; break;
            case 7: s = "воскресенье"; break;
                default: s = "такого дня недели не существует";
        }
        System.out.println(s);
    }
}