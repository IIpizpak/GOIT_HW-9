package com.goit.task2;

/*
Дан текстовый файл file.txt, необходимо считать файл в список объектов User и создать новый файл user.json.

Предполагаем, что каждая строка содержит одинаковое количество "колонок", разделенный пробелом.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public ArrayList<String> txtToObject(String filepath) throws IOException {
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        ArrayList<String> userList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            userList.add(scanner.nextLine());
        }
        scanner.close();
        System.out.println(userList.toString());
        return userList;
    }
}
