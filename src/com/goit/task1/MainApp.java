package com.goit.task1;

import java.io.FileNotFoundException;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        PhoneNumbers file = new PhoneNumbers();
        file.fileToNumbers("C:\\workspace\\GOIT_HW-9\\src\\com\\goit\\task1\\file.txt");
    }
}
