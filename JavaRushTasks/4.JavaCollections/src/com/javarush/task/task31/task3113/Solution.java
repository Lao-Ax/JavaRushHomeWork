package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?

Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.


Требования:
1. Метод main должен считывать путь к папке с консоли.
2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории]".
4. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и
поддиректориях]".
5. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в
директории]".
*/
public class Solution extends SimpleFileVisitor<Path> {

    static int directoriesCount = -1;
    static int filesCount = 0;
    static long size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String directory = bufferedReader.readLine();
        bufferedReader.close();

        if (!Files.isDirectory(Paths.get(directory))) {
            System.out.println(directory + " - не папка");
        } else {

            final Solution solution = new Solution();
            Files.walkFileTree(Paths.get(directory), solution);
            System.out.println("Всего папок - " + directoriesCount);
            System.out.println("Всего файлов - " + filesCount);
            System.out.println("Общий размер - " + size);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        try {
            filesCount++;
            size += Files.size(file);
        } catch (IOException e) {
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        directoriesCount++;
        return FileVisitResult.CONTINUE;
    }
}