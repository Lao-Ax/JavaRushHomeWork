package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileOne);

        int sizeOfFileInBytes = inputStream.available();
        byte[] buffer = new byte[sizeOfFileInBytes];

        FileOutputStream outputStreamTwo = new FileOutputStream(fileTwo);
        inputStream.read(buffer);

        for (int i = sizeOfFileInBytes-1; i >= 0; i--){
            outputStreamTwo.write(buffer[i]);
        }
        outputStreamTwo.close();
        inputStream.close();
    }
}
