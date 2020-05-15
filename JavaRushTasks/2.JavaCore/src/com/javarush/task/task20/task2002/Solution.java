package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
В файле your_file_name.tmp может быть несколько объектов JavaRush.
Метод main реализован только для вас и не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) {
        try {
            OutputStream outputStream = new FileOutputStream("1");
            InputStream inputStream = new FileInputStream("1");

            JavaRush javaRush = new JavaRush();

            User user = new User();
            user.setFirstName("Alex");
            user.setLastName("Plekhov");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
            user.setBirthDate(sdf.parse("02.11.1988"));
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user);

            User userTwo = new User();
            userTwo.setFirstName("Valeria");
//            userTwo.setLastName("Loseva");
            userTwo.setBirthDate(sdf.parse("23.12.2001"));
            userTwo.setMale(false);
//            userTwo.setCountry(User.Country.UKRAINE);
            javaRush.users.add(userTwo);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush javaRushTwo = new JavaRush();

            User userThree = new User();
            userThree.setFirstName("Java");
            userThree.setLastName("Rush");
            userThree.setBirthDate(sdf.parse("30.06.2005"));
            userThree.setMale(true);
            userThree.setCountry(User.Country.RUSSIA);
            javaRushTwo.users.add(userThree);

            javaRushTwo.save(outputStream);
            outputStream.flush();


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));

//            JavaRush loadedObjectTwo = new JavaRush();
//            loadedObjectTwo.load(inputStream);
//            System.out.println(javaRushTwo.equals(loadedObjectTwo));


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintStream writer = new PrintStream(outputStream);
            writer.println("new java rush object");
            if (users.size() != 0) {
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                    writer.println(sdf.format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry());
                }
            }
            writer.println("end java rush object");
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (reader.readLine().equals("new java rush object")) {
                users = new ArrayList<>();
                String str;
                while (!(str = reader.readLine()).equals("end java rush object") && reader.ready()) {
                    User user = new User();
                    if (!(str).equals("null"))
                        user.setFirstName(str);

                    if (!(str = reader.readLine()).equals("null"))
                        user.setLastName(str);

                    if (!(str = reader.readLine()).equals("null")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                        user.setBirthDate(sdf.parse(str));
                    }

                    user.setMale(Boolean.valueOf(reader.readLine()));

                    if (!(str = reader.readLine()).equals("null")) {
                        user.setCountry(User.Country.valueOf(str));
                    }
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
