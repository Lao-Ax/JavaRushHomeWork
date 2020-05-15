package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив

В метод main приходит список аргументов.
Первый аргумент — полный путь к файлу fileName.
Второй аргумент — путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию ‘new‘.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String zipPath = args[1];
        String fileName = filePath.split("\\" + File.separator)[filePath.split("\\"+File.separator).length-1];

        List<ZipEntry> zipEntries = readZip(zipPath);

        FileOutputStream zipFile = new FileOutputStream(zipPath);
        ZipOutputStream zipStream = new ZipOutputStream(zipFile);

        for (ZipEntry zipEntry : zipEntries) {
            if (zipEntry != null) {
                zipStream.putNextEntry(zipEntry);
            }
        }

        zipStream.putNextEntry(new ZipEntry(fileName));

        Files.copy(Paths.get(filePath), zipStream);

        zipFile.close();
        zipStream.close();
    }

    private static List<ZipEntry> readZip(String zipPath) throws IOException {
        FileInputStream zipFile = new FileInputStream(zipPath);
        ZipInputStream zipStream = new ZipInputStream(zipFile);
        List<ZipEntry> zipEntries = new ArrayList<>();

        while (zipStream.available() > 0) {
            zipEntries.add(zipStream.getNextEntry());
        }

        zipStream.close();
        zipFile.close();
        return zipEntries;
    }
}
