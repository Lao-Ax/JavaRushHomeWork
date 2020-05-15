package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);

        testString.printSomething();

        String result = calculate(outputStream.toString());

        System.setOut(console);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }

    private static String calculate(String str){
        String[] primer = str.split(" ");
        int a = Integer.parseInt(primer[0]);
        int b = Integer.parseInt(primer[2]);

        int result = 0;
        switch (primer[1]){
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
        }

        return String.format("%d %s %d = %d", a, primer[1], b, result);
    }
}

