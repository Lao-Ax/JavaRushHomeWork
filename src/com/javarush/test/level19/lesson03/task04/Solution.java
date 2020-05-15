package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        PersonScanner personScanner = new PersonScannerAdapter(new Scanner(System.in));
        Person person = personScanner.read();
        System.out.println(person.toString());
        personScanner.close();
    }


    public static class PersonScannerAdapter implements PersonScanner {
        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException{
            String[] line = scanner.nextLine().split(" ");
            String lastName = line[0],
                   firstName = line[1],
                   middleName  = line[2],
                   birthDate= line[3] + line[4] + line[5];
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            Date date = null;
            try{
                date = sdf.parse(birthDate);
            }catch (ParseException e){
                e.printStackTrace();
            }
            return new Person(firstName, middleName, lastName, date);
        }

        @Override
        public void close() throws IOException{
            scanner.close();
        }
    }
}
