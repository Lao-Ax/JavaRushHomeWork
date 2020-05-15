package com.javarush.test.level16.lesson10.task05;

import java.util.ArrayList;
import java.util.List;

/* Один для всех, все - для одного
1.part1. Разберись, как работает программа.
1.part1.1.part1. Обрати внимание, что объект Water - один для всех нитей.

2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
3. В методе run исправь значения переменных:
3.1.part1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
*/

public class Solution {
    public static byte countThreads = 3;
    static List<Thread> threads = new ArrayList<Thread>(countThreads);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        for (Thread t : threads){
            t.interrupt();
        }
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        for (int i = 0; i < countThreads; i++) {
            threads.add(new Thread(water, "#" + i));
        }

        for (int i = 0; i < countThreads; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String commonResource;

        public Water(String commonResource) {
            this.commonResource = commonResource;
        }

        public void run() {
            String threadName = Thread.currentThread().getName();

            try {
                boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
                while (!isCurrentThreadInterrupted) {
                    System.out.println("Объект " + commonResource + ", нить " + threadName);
                    Thread.sleep(800);
                    isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
                }
            } catch (InterruptedException e) {
                System.out.println("Объект " + commonResource + ", нить " + threadName + " Исключение!");
            }
        }
    }
}
