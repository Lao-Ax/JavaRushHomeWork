package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties

В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут — http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        try {
            String fileName;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            reader.close();

            FileInputStream fileInputStream = new FileInputStream(fileName);
            load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            // ignore
        }
    }

    public void save(OutputStream outputStream) {
        PrintStream writer = new PrintStream(outputStream);
        Properties propert = new Properties();
        propert.putAll(properties);
        try {
            propert.store(writer, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void load(InputStream inputStream) {
        try {
            Properties propert = new Properties();
            propert.load(inputStream);
            for(Map.Entry<Object, Object> prop : propert.entrySet()) {
                properties.put(prop.getKey().toString(), prop.getValue().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.fillInPropertiesMap();
//        properties.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
//
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream("3");
//            solution.save(fileOutputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
