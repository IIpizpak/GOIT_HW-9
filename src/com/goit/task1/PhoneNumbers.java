package com.goit.task1;

/*
Дан текстовый файл file.txt, который содержит список номеров телефоном (один на линии).
Необъодимо написать метод, который будет считывать файл и выводить в консоль все валидные номера телефонов.

Предполагаем, что "валидный" номер телефона - это строка в одном из двух форматов:
(xxx) xxx-xxxx или xxx-xxx-xxxx (х обозначает цифру).
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneNumbers {

    public void fileToNumbers(String filename) throws FileNotFoundException {

        List<String> numbersList = new ArrayList<>();
        File file = new File(filename);
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()) {
            numbersList.add(scanner.nextLine());
        }

        for (String list : numbersList) {
            char[] chars = list.toCharArray();
            if ((chars[0] == '(' && Character.isDigit(chars[1]) && Character.isDigit(chars[2])
                    && Character.isDigit(chars[3]) && chars[4] == ')' && chars[5] == ' ' && Character.isDigit(chars[6])
                    && Character.isDigit(chars[7]) && Character.isDigit(chars[8]) && chars[9] == '-' && Character.isDigit(chars[10])
                    && Character.isDigit(chars[11]) && Character.isDigit(chars[12]) && Character.isDigit(chars[13]) && chars.length == 14) ||
                    (Character.isDigit(chars[0]) && Character.isDigit(chars[1]) && Character.isDigit(chars[2]) &&
                            chars[3] == '-' && Character.isDigit(chars[4]) && Character.isDigit(chars[5]) && Character.isDigit(chars[6]) &&
                            chars[7] == '-' && Character.isDigit(chars[8]) && Character.isDigit(chars[9]) && Character.isDigit(chars[10]) &&
                            Character.isDigit(chars[11]) && chars.length == 12)) {
                System.out.println(list);
            }
        }
    }
}
