package com.javarush.task.task19.task1916;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task19.task1916.Solution.Type.ADDED;
import static com.javarush.task.task19.task1916.Solution.Type.REMOVED;
import static com.javarush.task.task19.task1916.Solution.Type.SAME;

/* 
Отслеживаем изменения

Считать с консоли 2 имени файла — file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
В оригинальном и редактируемом файлах пустых строк нет.

Пример:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2         REMOVED            строка2
строка3         строка3            SAME строка3
строка4         REMOVED            строка4
строка5         строка5            SAME строка5
строка0         ADDED              строка0
строка1         строка1            SAME строка1
строка2         REMOVED            строка2
строка3         строка3            SAME строка3
строка5         ADDED              строка5
строка4         строка4            SAME строка4
строка5         REMOVED            строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        BufferedReader fileOneReader = new BufferedReader(new FileReader(fileNameOne));
        BufferedReader fileTwoReader = new BufferedReader(new FileReader(fileNameTwo));

        List<String> list1 = new ArrayList<>();
        while (fileOneReader.ready()) {
            list1.add(fileOneReader.readLine());
        }

        List<String> list2 = new ArrayList<>();
        while (fileTwoReader.ready()) {
            list2.add(fileTwoReader.readLine());
        }

        fileOneReader.close();
        fileTwoReader.close();

        /*** --- ***/
        for (int i = 0, j = 0; i < list1.size() || j < list2.size(); i++, j++) {
            if (j == list2.size()) {
                lines.add(new LineItem(REMOVED, list1.get(i)));
            } else if (i == list1.size()) {
                lines.add(new LineItem(ADDED, list2.get(j)));
            } else if (list1.get(i).equals(list2.get(j))) {
                lines.add(new LineItem(SAME, list1.get(i)));
            } else if (list1.get(i).equals(list2.get(j + 1))) {
                lines.add(new LineItem(ADDED, list2.get(j)));
                i--;
            } else if (list1.get(i + 1).equals(list2.get(j))) {
                lines.add(new LineItem(REMOVED, list1.get(i)));
                j--;
            }
        }

        lines.forEach((lineItem) -> System.out.println(lineItem.type + "  " + lineItem.line));
    }

    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
