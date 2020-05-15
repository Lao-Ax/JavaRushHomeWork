package com.javarush.task.task01.task0109;

/* 
«Я по объявлению…»
*/

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws MalformedURLException, IOException{
        int a = 0;
        int b = 1;

        URL url = new URL("https://www.google.com.ua/images/srpr/logo11w.png");
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile);
    }
}
