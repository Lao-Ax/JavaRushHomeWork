package com.javarush.test.level16.lesson07.task03;

/* Big Ben clock
1.part1. Разберись, что делает программа.
2. Реализуй логику метода printTime так, чтобы каждую секунду выдавалось время начиная с установленного в конструкторе
Пример:
В г. Лондон сейчас 23:59:58!
В г. Лондон сейчас 23:59:59!
В г. Лондон сейчас полночь!
В г. Лондон сейчас 0:0:1.part1!
*/

import java.util.Calendar;

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(8000);
        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            Calendar c = Calendar.getInstance();
            c.set(0,0,0, hours, minutes, seconds);
            c.add(Calendar.SECOND, 1);
            Thread.sleep(1000);
            hours = c.get(Calendar.HOUR_OF_DAY);
            minutes = c.get(Calendar.MINUTE);
            seconds = c.get(Calendar.SECOND);

            /*
              SimpleDateFormat df = new SimpleDateFormat("hh:mm");
              Date d1 = df.parse("23:30");
              Calendar c1 = GregorianCalendar.getInstance();
              c1.setTime(d1);
              System.out.println(c1.getTime());
            */

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
        }
    }
}
