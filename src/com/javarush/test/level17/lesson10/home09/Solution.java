package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1.part1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines

В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines

4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1.part1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Path filePathOne = null;
        Path filePathTwo = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            filePathOne = Paths.get(reader.readLine());
            filePathTwo = Paths.get(reader.readLine());

            readFirstFile(filePathOne);
            readSecondFile(filePathTwo);

            Solution solution = new Solution();
            solution.joinData();
        }catch (CorruptedDataException e) {
            System.out.print("Ошибка в данных");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static void readFirstFile(Path filePathOne) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathOne.toString()))) {
            String s;
            while ((s = reader.readLine()) != null) {
                allLines.add(s);
            }
        }
    }

    public static void readSecondFile(Path filePathTwo) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathTwo.toString())))
        {
            String s;
            while ((s = reader.readLine()) != null)
            {
                forRemoveLines.add(s);
            }
        }
    }
}
