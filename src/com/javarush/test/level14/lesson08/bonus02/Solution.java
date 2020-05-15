package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception {
        int x, y, d;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            x = Integer.parseInt(reader.readLine());
            y = Integer.parseInt(reader.readLine());
            d = gcd(x, y);
            System.out.println("НОД = " + d);
        } catch (NumberFormatException e) {
            System.out.println("Одно из чисел введено некорректно.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
