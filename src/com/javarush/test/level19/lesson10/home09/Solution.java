package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        MyPrintStream myPrintStream = new MyPrintStream(console);
        System.setOut(myPrintStream);

        testString.printSomething();

        System.setOut(console);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class MyPrintStream extends PrintStream {
        PrintStream console;
        int adCount = 1;

        public MyPrintStream(OutputStream out) {
            super(out);
            this.console = new PrintStream(out);
        }

        @Override
        public void println(String str) {
            if (adCount % 2 == 0) {
                console.println(str);
                console.println("JavaRush - курсы Java онлайн");
            } else {
                console.println(str);
            }
            adCount = adCount % 2 + 1;
        }
    }
}
