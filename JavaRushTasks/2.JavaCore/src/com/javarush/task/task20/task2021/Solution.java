package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации

Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        public void writeObject(OutputStream out) throws NotSerializableException {
            throw new NotSerializableException();
        }

        public void readObject(InputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
