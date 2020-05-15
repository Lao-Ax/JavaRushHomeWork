package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        FileReader fileOneReader = new FileReader(fileNameOne);
        FileWriter fileTwoWriter = new FileWriter(fileNameTwo);

        int countOfReadBytes = 0;
        while (fileOneReader.ready()){
            int i = fileOneReader.read();
            countOfReadBytes++;
            if (countOfReadBytes % 2 == 0) {
                fileTwoWriter.write(i);
            }
        }

        fileOneReader.close();
        fileTwoWriter.close();
    }
}
