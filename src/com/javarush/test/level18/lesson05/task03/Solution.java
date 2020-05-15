package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        String fileThree = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileOne);

        int allFile = inputStream.available();
        int count = allFile % 2 == 0 ? allFile / 2 : (allFile + 1) / 2;

        byte[] bufferFileTwo = new byte[count];
        byte[] bufferFileThree= new byte[allFile - count];

        FileOutputStream outputStreamTwo = new FileOutputStream(fileTwo);
        inputStream.read(bufferFileTwo);
        outputStreamTwo.write(bufferFileTwo, 0, count);
        outputStreamTwo.close();

        FileOutputStream outputStreamThree = new FileOutputStream(fileThree);
        inputStream.read(bufferFileThree);
        outputStreamThree.write(bufferFileThree, 0, allFile - count);
        outputStreamThree.close();

        inputStream.close();
    }
}
