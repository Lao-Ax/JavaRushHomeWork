package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png", Paths.get("E:/Temp/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        String[] prefixAndSuffix = urlString.substring(urlString.lastIndexOf('/') + 1).split("\\.");

        Path tempFile = Files.createTempFile(prefixAndSuffix[0], "." + prefixAndSuffix[1]);
        Files.copy(inputStream, tempFile, REPLACE_EXISTING);
        if (Files.notExists(downloadDirectory)) {
            Files.createDirectory(downloadDirectory);
        }
        Path downloadedFile = Files.move(tempFile, downloadDirectory.resolve(tempFile.getFileName()));
        return Files.move(downloadedFile, downloadedFile.resolveSibling(prefixAndSuffix[0] + "." + prefixAndSuffix[1]), REPLACE_EXISTING);
    }
}
