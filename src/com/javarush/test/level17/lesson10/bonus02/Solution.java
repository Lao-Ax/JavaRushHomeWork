package com.javarush.test.level17.lesson10.bonus02;

import com.javarush.test.level17.lesson10.bonus01.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1.part1
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.handleParameters(args);
    }

    private synchronized void handleParameters(String... args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                String str = args[i];
                try {
                    switch (str) {
                        case "-c":
                            i++;
                            while (i < args.length && !args[i].startsWith("-")){
                                allPeople.add(createPerson(i, args));
                                System.out.println(allPeople.size() - 1);
                                i += 3;
                            }
                            i--;
                            break;

                        case "-u":
                            i++;
                            while (i < args.length && !args[i].startsWith("-")){
                                updatePerson(i, args);
                                i += 4;
                            }
                            i--;
                            break;

                        case "-d":
                            i++;
                            while (i < args.length && !args[i].startsWith("-")){
                                deletePerson(Integer.parseInt(args[i]));
                                i++;
                            }
                            i--;
                            break;

                        case "-i":
                            i++;
                            while (i < args.length && !args[i].startsWith("-")){
                                printPersonInfo(Integer.parseInt(args[i]));
                                i++;
                            }
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

        String name = args[curArgument];
        Sex sex = readSex(args[curArgument +1]);
        Date date = readDate(args[curArgument +2]);

        person = sex == Sex.MALE ? Person.createMale(name, date) :Person.createFemale(name, date);

        return person;
    }

    private void updatePerson(int curArgument, String... args) throws ParseException{
        int id = Integer.valueOf(args[curArgument]);
        String name = args[curArgument +1];
        Sex sex = readSex(args[curArgument +2]);
        Date date = readDate(args[curArgument +3]);

        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
        person.setBirthDay(date);
    }

    private void deletePerson(int id){
        Person person = allPeople.get(id);
        person.setBirthDay(null);
        person.setName(null);
        person.setSex(null);
    }

    private void printPersonInfo(int id){
        Person person = allPeople.get(id);

        String sex = person.getSex() == Sex.MALE ? "м" : "ж";
        SimpleDateFormat sdf_for_print = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String date = sdf_for_print.format(person.getBirthDay());

        System.out.println(person.getName() + " " + sex + " " + date);
    }
}
