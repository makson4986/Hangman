package org.example;

import java.util.Scanner;

public class InputData {
    public static GameState inputAnswerOnSuggestGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Начать новую игру или выйти
                    1. Начать
                    2. Выйти""");

            String answer = scanner.nextLine();

            if (answer.length() == 1) {
                if (Character.isDigit(answer.charAt(0))) {
                    if (answer.equals("1")) {
                        return GameState.RUNNING;
                    } else if (answer.equals("2")) {
                        return GameState.ENDING;
                    }
                }
            }

            System.out.println("Неправильный вариант ответа!");
        }
    }

    public static char inputLetter() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите букву: ");

            String letter = scanner.nextLine();

            if (letter.length() == 1) {
                if (Character.isLetter(letter.charAt(0))) {
                    return Character.toLowerCase(letter.charAt(0));
                }
            }

            System.out.println("Некорректные данные!\n");
        }
    }
}
