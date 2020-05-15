package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов

1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять «n«.
Все файлы имеют расширение txt.

*/
public class Solution {
    private static List<File> filesWithLengthMore50 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
//        String path = "f:\\TEMP\\";
        String path = args[0];
//        String resultFileAbsolutePath = "F:\\IntelliJ IDEA work\\JavaRushHomeWork\\JavaRushTasks\\1.txt"; //args[1];
        String resultFileAbsolutePath = args[1];

        File resultFile = new File(resultFileAbsolutePath);
        String allFilesContent = resultFile.getParent() + "\\allFilesContent.txt";
        FileUtils.renameFile(resultFile, new File(allFilesContent));

        try (FileOutputStream writer = new FileOutputStream(allFilesContent)) {
            File folder = new File(path);
            walkIntoFolder(folder);

            filesWithLengthMore50.sort(Comparator.comparing(File::getName));

            for (File file : filesWithLengthMore50) {
                try (FileInputStream reader = new FileInputStream(file)) {
                    while (reader.available() > 0) {
                        writer.write(reader.read());
                    }
                    writer.write("\n".getBytes());
//                    writer.write(System.lineSeparator().getBytes());
                    writer.flush();
                    reader.close();
                }
            }
            writer.close();
        }
    }

    public static void walkIntoFolder(File startFolder) {
        if (startFolder.isDirectory()) {
            List<File> folderEntry = Arrays.asList(startFolder.listFiles());
            for (File file : folderEntry) {
                walkIntoFolder(file);
            }
        } else {
            File file = startFolder;
            if (file.length() > 50) {
                FileUtils.deleteFile(file);
            } else {
                filesWithLengthMore50.add(file);
            }
        }
    }
}
