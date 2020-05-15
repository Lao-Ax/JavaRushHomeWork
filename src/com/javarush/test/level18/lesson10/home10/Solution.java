package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        Map<Integer, String> files = new TreeMap<>();

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String consoleInput;
        while (!(consoleInput = fileNameReader.readLine()).equals("end")) {
            int part = Integer.parseInt(consoleInput.substring(consoleInput.lastIndexOf(".")+1).replace("part",""));
            files.put(part, consoleInput);
        }
        fileNameReader.close();
        String resultFileName = files.get(1).substring(0, files.get(1).lastIndexOf("."));
        System.out.println(resultFileName);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(resultFileName));

        for (int i = 1; i <= files.size(); i++) {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(files.get(i)));
            byte[] fileContent = new byte[bis.available()];
            bis.read(fileContent);
            bos.write(fileContent);
            bos.flush();
            bis.close();
        }
        bos.close();
    }
}
