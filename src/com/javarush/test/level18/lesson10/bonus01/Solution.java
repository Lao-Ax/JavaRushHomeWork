package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {

    private String fileName;
    private String fileOutputName;


    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.fileName = args[1];
        solution.fileOutputName = args[2];
        if (args[0].equals("-e")){
            solution.encrypt();
        } else {
            solution.decrypt();
        }
    }

    private void encrypt() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

        while (fileInputStream.available() > 0) {
            fileOutputStream.write(fileInputStream.read()+1);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    private void decrypt() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

        while (fileInputStream.available() > 0) {
            fileOutputStream.write(fileInputStream.read()-1);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
