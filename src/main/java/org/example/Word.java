package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Word {
    private final String WORD;
    private final File PATH = new File("src/main/java/org/example/Words.txt");

    public Word() {
        WORD = generateNewWord();
    }

    private String generateNewWord() {
        List<String> words = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(PATH);

            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                words.add(word.toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл с исходными словами не найден!");
        }

        return words.get(new Random().nextInt(words.size()));
    }

    public String getWord() {
        return WORD;
    }
}
