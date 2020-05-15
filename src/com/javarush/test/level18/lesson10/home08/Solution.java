package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = fileNameReader.readLine()).equals("exit")){
            new ReadThread(fileName).run();
        }
        fileNameReader.close();
    }

    public static class ReadThread extends Thread{
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            InputStream in = null;
            try {
                in = new FileInputStream(fileName);
                int maxByte = 0;

                synchronized (resultMap){
                    resultMap.put(fileName, getMostFrequentByte(in));
                }
            } catch (IOException e) {
            } finally { try{ in.close(); } catch (IOException e) { e.printStackTrace();}
            }
        }

        private int getMostFrequentByte(InputStream inputStream) throws IOException{
            Map<Integer, Integer> byteIntegerMap = new TreeMap<>();
            for (int i = 0; i < 255; i++){
                byteIntegerMap.put(i, 0);
            }

            while (inputStream.available() > 0) {
                int b = inputStream.read();
                byteIntegerMap.put(b, byteIntegerMap.get(b)+1);
            }

            int maxRepeat = Byte.MIN_VALUE;
            int byteMaxRepeated = 0;
            for (Map.Entry<Integer, Integer> pair : byteIntegerMap.entrySet()) {
                if (pair.getValue() > maxRepeat) {
                    maxRepeat = pair.getValue();
                    byteMaxRepeated = pair.getKey();
                }
            }
            return byteMaxRepeated;
        }

    }
}
