package com.goit.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordsCounter {

    public static void main(String[] args) {
        WordsCounter test = new WordsCounter();
        test.wordCounter("C:\\workspace\\GOIT_HW-9\\src\\com\\goit\\task3\\words.txt");
    }

    Map<String, Integer> wordsCount = new HashMap<>();
    List<String> words = new ArrayList<>();


    public void wordCounter(String filepath) {
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String word : words) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }
        System.out.println(wordsCount.toString());
    }
}
