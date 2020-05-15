package com.javarush.test.level15.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;/* Осваивание статического блока
1.part1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс Flyable.
2. Класс Plane должен иметь 1.part1 конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1.part1. Считать с консоли параметр типа String. Параметр может быть "plane" или "helicopter".
3.2. Закрыть поток ввода методом close().
3.3. Если параметр равен "helicopter", то статическому объекту Flyable result присвоить объект класса Helicopter.
3.4. Если параметр равен "plane", то считать второй параметр типа int, статическому объекту Flyable result присвоить
объект класса Plane.
4. В статическом блоке инициализировать Flyable result вызвав метод reset.
*/

public class Solution {
    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String s = reader.readLine();
            if (s.equalsIgnoreCase("plane")) {
                int i;
                try {
                    i = Integer.parseInt(reader.readLine());
                    result = new Plane(i);
                } catch (NumberFormatException e) {
                    System.out.print(e.getMessage());
                }
            } else if (s.equalsIgnoreCase("helicopter")) {
                result = new Helicopter();
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } finally
        {
            try { reader.close(); } catch (IOException e) { e.printStackTrace();}
        }
    }
}
