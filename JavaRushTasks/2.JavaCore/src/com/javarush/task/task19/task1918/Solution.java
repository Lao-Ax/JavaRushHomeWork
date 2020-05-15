package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами

Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, «span«.
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, n, r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static String tag, line;
    private static Map<Integer, String> tagsEntryMap = new TreeMap<>();
    private static int currentIndex = 0;
    private static Matcher openTagMatcher;
    private static int tagsCount = 0;

    public static void main(String[] args) throws IOException {
        tag = "span";
        line = turnFileInOneLine("1");

        openTagMatcher = Pattern.compile("<" + tag + ".*?>|</" + tag + ">").matcher(line);
        openTagMatcher.find();
        currentIndex = openTagMatcher.start();

        while (currentIndex != -1) {
            currentIndex = tagFinder(currentIndex);
        }

        printTags();
    }

    private static void printTags() {
        tagsEntryMap.entrySet().stream().forEach(entry -> System.out.println(entry.getValue()));
    }

    private static String turnFileInOneLine(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append(fileReader.readLine());
        }
        fileReader.close();
        return stringBuilder.toString();
    }

    public static int tagFinder(int startIndex) {
        int currentTagNumber = tagsCount++;
        int tagStart;
        int tagEnd;

        while (openTagMatcher.find()) {
            tagStart = openTagMatcher.start();
            if (!line.substring(tagStart, tagStart + 2).equals("</")) {
                int endOfEntry = tagFinder(tagStart);
                currentIndex = endOfEntry;
            } else {
                tagEnd = openTagMatcher.end();
                tagsEntryMap.put(currentTagNumber, line.substring(startIndex, tagEnd));
                return tagEnd;
            }
        }
        return -1;
    }
}
