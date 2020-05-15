package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filenameOne = reader.readLine();
        String filenameTwo = reader.readLine();
        String filenameThree = reader.readLine();
        reader.close();

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filenameOne, true));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filenameTwo));

        byte[] fileContent = new byte[bis.available()];
        bis.read(fileContent);
        bos.write(fileContent);
        bis.close();
        bos.flush();

        BufferedInputStream bis2 = new BufferedInputStream(new FileInputStream(filenameThree));
        fileContent = new byte[bis2.available()];
        bis2.read(fileContent);
        bos.write(fileContent);

        bis2.close();
        bos.close();
    }
}
