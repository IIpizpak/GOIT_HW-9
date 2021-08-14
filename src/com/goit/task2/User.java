package com.goit.task2;

/*
Дан текстовый файл file.txt, необходимо считать файл в список объектов User и создать новый файл user.json.

Предполагаем, что каждая строка содержит одинаковое количество "колонок", разделенный пробелом.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Serializable {
    private String name;
    private Integer age;



    List<User> users = new ArrayList<>();

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

    public List<User> txtToJson(String filepath) throws IOException {
        File file = new File(filepath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] str = scanner.nextLine().split(" ");
                if (str[1].matches("[0-9]+")) {
                    User user = new User();
                    user.setName(str[0]);
                    user.setAge(Integer.parseInt(str[1]));
                    users.add(user);
                }
            }
        }

        System.out.println("List of users from method txtToJson " + users.toString());
        String json = new Gson().toJson(users);
        try (FileWriter fileWriter = new FileWriter("C:\\workspace\\GOIT_HW-9\\src\\com\\goit\\task2\\users.json")){
            fileWriter.write(json);
            fileWriter.flush();
        };
        System.out.println(json);
        return users;
    }
}
