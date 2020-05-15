package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Row> rows = new ArrayList();

    public static void main(String[] args) throws Exception {
        if (!args[0].equals("-c")) return;

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String row;
            while ((row = br.readLine()) != null) {
                rows.add(new Row(parseId(row), parseProductName(row), parsePrice(row), parseQuantity(row)));
            }
            br.close();
        } catch (FileNotFoundException e) {}

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
//        bw.newLine();
        bw.write(new Row(args[1], Double.parseDouble(args[2]), Integer.parseInt(args[3])).toString());
        bw.close();
    }

    private static int parseId(String row){
        return Integer.parseInt(row.substring(0, 8).trim());
    }

    private static String parseProductName(String row){
        return row.substring(8, 38);
    }

    private static double parsePrice(String row){
        return Double.parseDouble(row.substring(38, 46).trim());
    }

    private static int parseQuantity(String row){
        return Integer.parseInt(row.substring(46).trim());
    }

    private static class Row{
        int id;
        String productName;
        double price;
        int quantity;

        public Row(int id, String productName, double price, int quantity)
        {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public Row(String productName, double price, int quantity)
        {
            this.id = generateId();
            this.productName = productName.length() >= 30 ? productName.substring(0,30) : productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int generateId(){
            int maxId = Integer.MIN_VALUE;
            for (Row row : rows) {
                maxId = maxId > row.id ? maxId : row.id;
            }
            return ++maxId;
        }

        public String toString(){
            String id = String.format("%-8d", this.id);
            String productName = String.format("%-30s", this.productName);
            String price = String.format("%-8.2f", this.price);
            String quantity = String.format("%-4d", this.quantity);

            StringBuilder sb = new StringBuilder();
            sb.append(id).append(productName).append(price).append(quantity);

            return sb.toString();
        }
    }
}
