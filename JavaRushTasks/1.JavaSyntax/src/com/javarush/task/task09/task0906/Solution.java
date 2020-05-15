package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса

Реализовать метод log.
Он должен выводить на экран имя класса и имя метода (в котором вызывается метод log), а также переданное сообщение.
Имя класса, имя метода и сообщение разделить двоеточием с пробелом.

Пример вывода:
com.javarush.task.task09.task0906.Solution: main: In main method
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
//        metod();
    }

    public static void log(String s) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String S;
        S = stackTraceElements[2].getClassName().toString() + ": " + stackTraceElements[2].getMethodName().toString()
                + ": " + s;
        System.out.println(S);
    }

//    public static void metod(){
//        log("cat");
//    }
}
