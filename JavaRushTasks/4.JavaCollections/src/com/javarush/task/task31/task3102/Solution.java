package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Находим все файлы
Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/
public class Solution {

    private static List<String> list = new ArrayList<>();

    public static List<String> getFileTree(String root) throws IOException {
        File rootPath = new File(root);
        List<File> folderEntry = new ArrayList<>();
        folderEntry.addAll(Arrays.asList(rootPath.listFiles()));

        for (int i = 0; i < folderEntry.size(); i++) {
            File currentFile = folderEntry.get(i);
            if (currentFile.isDirectory()) {
                folderEntry.addAll(Arrays.asList(currentFile.listFiles()));
            } else {
                list.add(currentFile.getAbsolutePath());
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException{
        getFileTree("f:\\TEMP\\");
        list.forEach(System.out::println);
    }
}
