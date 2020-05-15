package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1.part1
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.handleParameters(args);
    }

    private void handleParameters(String... args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                String str = args[i];
                try {
                    switch (str) {
                        case "-c":
                            allPeople.add(createPerson(i, args));
                            System.out.println(allPeople.size()-1);
                            i += 3;
                            break;

                        case "-u":
                            updatePerson(i, args);
                            i+= 4;
                            break;

                        case "-d":
                            Person person = allPeople.get(Integer.parseInt(args[i+1]));
                            person.setBirthDay(null);
                            person.setName(null);
                            person.setSex(null);
                            i++;
                            break;

                        case "-i":
                            printPersonInfo(Integer.valueOf(args[i+1]));
                            i++;
                            break;

                        default:
                            System.out.printf("Параметр на позиции %d указан неверно.\n", i + 1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверно указан числовой параметр.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Последний параметр указан без значения.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Запрашиваемого id нет.");
                } catch (ParseException e){
                    System.out.println("Ошибка в формате одного из параметров.");
                }
            }
        }
    }

    private Date readDate(String nonFormatDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return sdf.parse(nonFormatDate);
    }

    private Sex readSex(String sex){
        if (sex.equalsIgnoreCase("м")) {
            return Sex.MALE;
        } else
            return Sex.FEMALE;
    }

    private Person createPerson(int curArgument, String... args) throws ParseException{
        Person person;

        String name = args[curArgument +1];
        Sex sex = readSex(args[curArgument +2]);
        Date date = readDate(args[curArgument +3]);

        person = sex == Sex.MALE ? Person.createMale(name, date) : Person.createFemale(name, date);

        return person;
    }

    private void updatePerson(int curArgument, String... args) throws ParseException{
        int id = Integer.valueOf(args[curArgument +1]);
        String name = args[curArgument +2];
        Sex sex = readSex(args[curArgument +3]);
        Date date = readDate(args[curArgument +4]);

        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
        person.setBirthDay(date);
    }

    private void printPersonInfo(int id){
        Person person = allPeople.get(id);

        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        SimpleDateFormat sdf_for_print = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = sdf_for_print.format(person.getBirthDay());

        System.out.println(person.getName() + " " + sex + " " + date);
    }
}
