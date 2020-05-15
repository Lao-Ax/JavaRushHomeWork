package com.javarush.test.level16.lesson05.task03;

/* Продвижение на политических дебатах
1.part1. Разберитесь, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov, чтобы Иванов разговаривал, пока не завершится всё свободное время.
*/

public class Solution {
    public static int totalCountSpeeches = 200;
    public static int soundsInOneSpeech = 1000;
    public static volatile int totalSounds = 0;

    public static void main(String[] args) throws InterruptedException {
        Politic ivanov = new Politic("Иванов");
        ivanov.join();
        Politic petrov = new Politic("Петров");
//        petrov.join();
        Politic sidorov = new Politic("Сидоров");
//        sidorov.join();

        while (totalSounds < totalCountSpeeches * soundsInOneSpeech) { // wait for totalSounds
        }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
        System.out.println(sidorov.getCountSpeaches() + petrov.getCountSpeaches() + ivanov.getCountSpeaches());
    }

    public static class Politic extends Thread {
        private int countSounds = 0;

        public Politic(String name) {
            super(name);
            start();
        }

        public void run() {
            while (totalSounds < totalCountSpeeches * soundsInOneSpeech) {
                totalSounds++;
                countSounds++;
            }
        }

        public int getCountSpeaches() {
            return countSounds;
        }

        @Override
        public String toString() {
            return String.format("%s сказал %d звуков.", getName(), getCountSpeaches());
        }
    }
}
