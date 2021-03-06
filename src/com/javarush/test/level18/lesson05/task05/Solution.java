package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1.part1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1.part1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        boolean ok = true;

        while (ok) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String fileName = reader.readLine();

                try(FileInputStream inputStream = new FileInputStream(fileName)){
                    if (inputStream.available() < 1000)
                    {
                        ok = false;
                        inputStream.close();
                        reader.close();
                        throw new DownloadException();
                    }
                }
            } catch (IOException e){
                ok = false;
            }
        }
    }

    public static class DownloadException extends Exception{

    }
}
