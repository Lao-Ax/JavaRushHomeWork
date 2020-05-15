package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1.part1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1.part1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        try {
            s = reader.readLine();
            if (!s.contains("?")) return;

//        "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//        "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
            s = s.substring(s.indexOf("?") + 1);
            String[] strList = s.split("&");
            String result = "";
            ArrayList<String> obj_param = new ArrayList<>();

            for (String str : strList)
            {
                if (str.contains("="))
                    result += (str.substring(0, str.indexOf("=")) + " ");
                else
                    result += (str + " ");

                if (str.startsWith("obj="))
                    obj_param.add(str.substring(str.indexOf("=") + 1));
            }

            System.out.println(result.substring(0, result.length() - 1));

            if (obj_param.size() != 0) {
                for (String s_obj : obj_param)
                try{
                    alert(Double.parseDouble(s_obj));
                } catch (NumberFormatException e) {
                    alert(s_obj);
                }
            }
        } catch (IOException e) {
            System.out.println("You've put something wrong.");}

        try {reader.close(); } catch (IOException e) { e.printStackTrace();}
    }

    public static void alert(double value) {System.out.println("double " + value);}

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
