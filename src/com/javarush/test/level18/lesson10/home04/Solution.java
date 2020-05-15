package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filenameOne = reader.readLine();
        String filenameTwo = reader.readLine();
        reader.close();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filenameOne));
        byte[] fileOneContent = new byte[bis.available()];
        bis.read(fileOneContent);
        bis.close();

        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(filenameTwo));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filenameOne));
        byte[] fileTwoContent = new byte[bis2.available()];
        bis2.read(fileTwoContent);
        bos.write(fileTwoContent);
        bos.flush();
        bos.write(fileOneContent);
        bos.flush();
        bis2.close();
        bos.close();




    }
}
