package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей

Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором
будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream
со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase();
    private static final String digits = "0123456789";
    private static final String alphanum = upper + lower + digits;

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword(){
        char[] buf;
        do {
            buf = generate();
        } while (!isVerified(buf));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new String(buf).getBytes());
        } catch (IOException ignored) {
        }

        return byteArrayOutputStream;
    }

    private static char[] generate() {
        char[] buf = new char[8];
        Random random = new Random();
        char[] symbols = alphanum.toCharArray();
        for (int idx = 0; idx < 8; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return buf;
    }

    private static boolean isVerified(char[] password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        for (char c : password) {
            if (upper.contains(String.valueOf(c))) {
                hasUpper = true;
            }
            if (lower.contains(String.valueOf(c))) {
                hasLower = true;
            }
            if (digits.contains(String.valueOf(c))) {
                hasDigit = true;
            }
            if (hasDigit && hasUpper && hasLower) break;
        }
        return hasDigit && hasUpper && hasLower;
    }
}